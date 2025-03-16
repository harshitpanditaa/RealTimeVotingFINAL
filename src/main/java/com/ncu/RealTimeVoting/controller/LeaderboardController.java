package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import com.ncu.RealTimeVoting.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @GetMapping("/leaderboard")
    public List<OptionVoteCount> getLeaderboard() {
        return leaderboardService.getLeaderboard();
    }
}

