package com.kodtodya.practice.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    /**
     * A fibonacci implementation, which is slow (on purpose).
     * See https://www.baeldung.com/java-fibonacci for more details
     */
    public Long nthFibonacciTerm(Long n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return nthFibonacciTerm(n - 1) + nthFibonacciTerm(n - 2);
    }

}
