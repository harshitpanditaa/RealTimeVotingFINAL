package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.Option;
import com.ncu.RealTimeVoting.entity.Vote;
import com.ncu.RealTimeVoting.repository.OptionRepository;
import com.ncu.RealTimeVoting.repository.VoteRepository;
import com.ncu.RealTimeVoting.repository.OptionVoteCountRepository;
import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final OptionRepository optionRepository;
    private final OptionVoteCountRepository optionVoteCountRepository;

    @Transactional
    public String castVote(Long userId, Long optionId) {
        if (voteRepository.existsByUserIdAndOptionId(userId, optionId)) {
            return "User has already voted for this option!";
        }

        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new RuntimeException("Option not found"));

        Vote vote = new Vote(null, userId, option);
        voteRepository.save(vote);

        OptionVoteCount voteCount = optionVoteCountRepository.findByOption(option)
                .orElse(new OptionVoteCount(null, option, 0));
        voteCount.setVoteCount(voteCount.getVoteCount() + 1);
        optionVoteCountRepository.save(voteCount);

        return "Vote submitted successfully!";
    }
}
