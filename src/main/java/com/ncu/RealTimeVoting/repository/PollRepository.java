package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    @Query("SELECT p FROM Poll p LEFT JOIN FETCH p.options")
    List<Poll> findAllWithOptions(); // Custom query to load options with polls
}

