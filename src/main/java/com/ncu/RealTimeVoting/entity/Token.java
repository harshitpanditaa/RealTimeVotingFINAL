package com.ncu.RealTimeVoting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "token") // Ensuring correct table mapping
@Getter
@Setter
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "token", nullable = false, unique = true) // Renamed to match repo method
    private String token;

    //  Constructor to fix TokenService error
    public Token(Long id, Long userId, String token) {
        this.id = id;
        this.userId = userId;
        this.token = token;
    }
}
