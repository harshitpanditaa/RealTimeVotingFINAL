package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import com.ncu.RealTimeVoting.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @GetMapping("/top")
    public ResponseEntity<List<OptionVoteCount>> getLeaderboard() {
        return ResponseEntity.ok(leaderboardService.getLeaderboard());
    }
}
