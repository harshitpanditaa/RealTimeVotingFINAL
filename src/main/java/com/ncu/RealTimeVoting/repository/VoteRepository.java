package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByUserIdAndOptionId(Long userId, Long optionId);
    boolean existsByUserIdAndOption_Poll_Id(Long userId, Long pollId);
}
