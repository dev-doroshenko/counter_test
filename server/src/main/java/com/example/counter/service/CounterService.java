package com.example.counter.service;

import com.example.counter.entity.Counter;
import com.example.counter.repository.CounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;

    public Counter getCounterById(Long id) {
        Optional<Counter> counter = counterRepository.findById(id);

        if (counter.isEmpty())
            throw new RuntimeException("Counter not found");

        return counter.get();
    }

    public void increaseCounterValue(Long id) {
        Counter counter = getCounterById(id);
        counter.setCounterValue(counter.getCounterValue() + 1);
        counterRepository.save(counter);
    }
}
