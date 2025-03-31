package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @GetMapping("/{pollId}")
    public ResponseEntity<?> getPollResults(@PathVariable Long pollId) {
        return ResponseEntity.ok(resultService.getResultsByPollId(pollId));
    }
}
