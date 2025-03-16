package com.ncu.RealTimeVoting.controller;

import com.ncu.RealTimeVoting.entity.Token;
import com.ncu.RealTimeVoting.repository.TokenRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@RestController
@RequestMapping("/api/tokens")
@CrossOrigin("*")
public class TokenController {

    private final TokenRepository tokenRepository;

    public TokenController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @GetMapping("/generateToken")
    public String generateToken(@RequestParam Long userId) {
        String tokenValue = UUID.randomUUID().toString();

        LocalDateTime expiryTime = Instant.ofEpochMilli(System.currentTimeMillis() + (10 * 60 * 1000))
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        Token token = new Token();
        token.setUserId(userId);
        token.setToken(tokenValue);
        token.setExpiresAt(expiryTime);

        tokenRepository.save(token);

        return tokenValue;
    }
}
