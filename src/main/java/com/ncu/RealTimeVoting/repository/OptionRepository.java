package com.ncu.RealTimeVoting.repository;

import com.ncu.RealTimeVoting.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    Optional<Option> findById(Long id);
}
