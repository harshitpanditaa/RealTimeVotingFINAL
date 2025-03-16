package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/{userId}/{optionId}")
    public ResponseEntity<String> vote(@PathVariable Long userId, @PathVariable Long optionId) {
        String result = voteService.castVote(userId, optionId);
        return ResponseEntity.ok(result);
    }
}
