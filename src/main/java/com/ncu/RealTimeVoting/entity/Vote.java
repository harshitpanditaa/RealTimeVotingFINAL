package com.ncu.RealTimeVoting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    private Poll poll; // NEW FIELD for linking vote to a poll

    // Updated constructor to store poll reference
    public Vote(Long id, Long userId, Option option, Poll poll) {
        this.id = id;
        this.userId = userId;
        this.option = option;
        this.poll = poll;
    }
}
