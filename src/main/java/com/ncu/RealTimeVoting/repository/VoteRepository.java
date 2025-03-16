package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByUserIdAndOptionId(Long userId, Long optionId);
}
