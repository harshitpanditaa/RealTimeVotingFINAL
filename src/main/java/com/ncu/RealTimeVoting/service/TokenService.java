package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.Token;
import com.ncu.RealTimeVoting.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public String generateToken(Long userId) {
        String token = UUID.randomUUID().toString();
        Token newToken = new Token(null, userId, token, LocalDateTime.now().plusMinutes(5));
        return token;
    }

    public boolean isValidToken(String token) {
        Optional<Token> storedToken = tokenRepository.findByToken(token);
        return storedToken.isPresent() && storedToken.get().getExpiresAt().isAfter(LocalDateTime.now());
    }
}
