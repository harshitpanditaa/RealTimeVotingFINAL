package com.ncu.RealTimeVoting.service;

import com.ncu.RealTimeVoting.entity.Poll;
import com.ncu.RealTimeVoting.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAllWithOptions(); // ✅ Use custom query
    }

}
