package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
