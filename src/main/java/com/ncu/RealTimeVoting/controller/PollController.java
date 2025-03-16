package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import com.ncu.RealTimeVoting.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @GetMapping("/{pollId}/results")
    public ResponseEntity<List<OptionVoteCount>> getResults(@PathVariable Long pollId) {
        List<OptionVoteCount> results = pollService.getResults(pollId);

        return ResponseEntity.ok(results);
    }
}

