package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import com.ncu.RealTimeVoting.repository.OptionVoteCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {
    private final OptionVoteCountRepository optionVoteCountRepository;

    public List<OptionVoteCount> getResults(Long pollId) {
        return optionVoteCountRepository.findByOption_Poll_Id(pollId);
    }
}
