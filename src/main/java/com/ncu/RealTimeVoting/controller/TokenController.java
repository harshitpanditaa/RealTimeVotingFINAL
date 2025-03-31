package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @GetMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestParam Long userId) {
        String token = tokenService.generateToken(userId);
        return ResponseEntity.ok(token);
    }
}
