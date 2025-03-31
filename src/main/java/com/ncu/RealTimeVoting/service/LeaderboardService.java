package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import com.ncu.RealTimeVoting.repository.OptionVoteCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {

    private final OptionVoteCountRepository optionVoteCountRepository;

    public List<OptionVoteCount> getLeaderboard() {
        return optionVoteCountRepository.findAll();
    }
}
