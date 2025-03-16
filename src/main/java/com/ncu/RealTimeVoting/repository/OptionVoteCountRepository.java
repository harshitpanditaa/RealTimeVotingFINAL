package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Option;
import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface OptionVoteCountRepository extends JpaRepository<OptionVoteCount, Long> {
    Optional<OptionVoteCount> findByOption(Option option);
    List<OptionVoteCount> findByOption_Poll_Id(Long pollId);
    List<OptionVoteCount> findAllByOrderByVoteCountDesc();
}
