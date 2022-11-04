package com.example.ex3;

import com.example.ex3.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex3Application  implements CommandLineRunner {

    @Autowired
    private MathService mathService;

    public static void main(String[] args) {
        SpringApplication.run(Ex3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Result of " + mathService.square(5));
    }
}
