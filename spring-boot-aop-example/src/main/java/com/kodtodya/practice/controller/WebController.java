package com.kodtodya.practice.controller;

import com.kodtodya.practice.service.FibonacciService;
import com.kodtodya.practice.config.LogMethodName;
import com.kodtodya.practice.config.MonitorTime;
import com.kodtodya.practice.config.RetryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class WebController {

    @Autowired
    private FibonacciService fibonacciService;

    @Cacheable("Fibonacci")
    @LogMethodName
    @MonitorTime
    @GetMapping(path = "/api/fibonacci/{number}")
    public Long fibonacci(@PathVariable(value = "number") Long number) {
        return fibonacciService.nthFibonacciTerm(number);
    }

    @RetryOperation
    @LogMethodName
    @PostMapping(path = "/api/storeData")
    public void storeData(@RequestParam(value = "data") String data) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        } else {
            System.out.println("Pretend everything went fine");
        }
    }
}
