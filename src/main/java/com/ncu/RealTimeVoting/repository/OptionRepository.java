package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByPollId(Long pollId);
}
