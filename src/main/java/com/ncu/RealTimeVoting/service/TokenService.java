package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.Token;
import com.ncu.RealTimeVoting.repository.TokenRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    // Generate and save a new token
    public String generateToken(Long userId) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token(null, userId, tokenValue); // Correct constructor
        tokenRepository.save(token);
        return tokenValue;
    }

    // retrieve token details
    public Optional<Token> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    // Delete token after use
    public void deleteToken(String token) {
        tokenRepository.findByToken(token).ifPresent(tokenRepository::delete);
    }
}
