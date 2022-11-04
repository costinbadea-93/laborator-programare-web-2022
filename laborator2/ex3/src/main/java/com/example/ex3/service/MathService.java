package com.example.ex3.service;

import org.springframework.stereotype.Component;

@Component
public class MathService {
    public int square(int n) {
        if(n < 0 ){
            throw new RuntimeException("n should be > 0");
        }
        return n * n;
    }

}
