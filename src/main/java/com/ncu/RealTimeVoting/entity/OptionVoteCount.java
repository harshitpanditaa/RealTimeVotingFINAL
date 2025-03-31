package com.ncu.RealTimeVoting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OptionVoteCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "poll_id", nullable = false)
    private Long pollId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;

    private int voteCount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_id", insertable = false, updatable = false)
    private Poll poll;

    // Fixed constructor to properly initialize fields
    public OptionVoteCount(Option option, Long pollId, int voteCount) {
        this.option = option;
        this.pollId = pollId;
        this.voteCount = voteCount;
    }
}
