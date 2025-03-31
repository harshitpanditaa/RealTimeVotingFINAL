package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.*;
import com.ncu.RealTimeVoting.repository.OptionRepository;
import com.ncu.RealTimeVoting.repository.OptionVoteCountRepository;
import com.ncu.RealTimeVoting.repository.TokenRepository;
import com.ncu.RealTimeVoting.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final TokenRepository tokenRepository;
    private final OptionRepository optionRepository;
    private final OptionVoteCountRepository optionVoteCountRepository;

    @Transactional
    public String castVote(Long userId, Long optionId, Long pollId, String tokenValue) {
        // Validate token
        Optional<Token> tokenOptional = tokenRepository.findByToken(tokenValue);
        if (tokenOptional.isEmpty()) {
            return "Invalid or expired token.";
        }
        Token token = tokenOptional.get();
        if (!token.getUserId().equals(userId)) {
            return "Token does not belong to this user.";
        }

        // Validate option
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new IllegalArgumentException("Option does not exist."));

        // Ensure option belongs to the correct poll
        if (!option.getPoll().getId().equals(pollId)) {
            return "Option does not belong to the specified poll.";
        }

        // Check if user has already voted in this poll
        if (voteRepository.existsByUserIdAndOption_Poll_Id(userId, pollId)) {
            return "User has already voted in this poll.";
        }

        // Save vote
        Vote vote = new Vote(null, userId, option, option.getPoll()); // Store poll reference
        voteRepository.save(vote);

        // Update vote count for that option & poll
        OptionVoteCount voteCount = optionVoteCountRepository.findByOptionAndPollId(option, pollId)
                .orElse(new OptionVoteCount(option, pollId, 0));

        voteCount.setVoteCount(voteCount.getVoteCount() + 1);
        optionVoteCountRepository.save(voteCount);

        // Invalidate token after use
        tokenRepository.delete(token);

        return "Vote successfully cast!";
    }
}
