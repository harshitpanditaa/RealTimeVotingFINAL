package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Option;
import com.ncu.RealTimeVoting.entity.OptionVoteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionVoteCountRepository extends JpaRepository<OptionVoteCount, Long> {
    List<OptionVoteCount> findByPollId(Long pollId);
    Optional<OptionVoteCount> findByOptionId(Long optionId);
    Optional<OptionVoteCount> findByOptionAndPollId(Option option, Long pollId);
}
