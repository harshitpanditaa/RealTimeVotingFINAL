package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/cast")
    public ResponseEntity<String> castVote(
            @RequestParam Long userId,
            @RequestParam Long optionId,
            @RequestParam Long pollId, // Added pollId to allow voting in different polls
            @RequestHeader("Authorization") String token) {

        // Remove "Bearer " prefix from token header
        String tokenValue = token.replace("Bearer ", "").trim();

        String result = voteService.castVote(userId, optionId, pollId, tokenValue); // Updated method call with pollId
        return ResponseEntity.ok(result);
    }
}
