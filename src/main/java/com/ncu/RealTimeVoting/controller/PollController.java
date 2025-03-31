package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.entity.Poll;
import com.ncu.RealTimeVoting.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @GetMapping("/all")
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.getAllPolls());
    }
}
