package com.example.counter.controller;

import com.example.counter.service.CounterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/counter")
public class CounterController {

    private final CounterService counterService;

    @GetMapping()
    public long getCounterValue() {
        return counterService.getCounterById(1L).getCounterValue();
    }

    @PostMapping("/increase")
    public void increaseCounterValue() {
        counterService.increaseCounterValue(1L);
    }
}
