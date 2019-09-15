package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        System.out.println("(".matches("[<,>,*]"));       // да
        System.out.println("123".matches("-?\\d+"));        // да
        System.out.println("+123".matches("-?\\d+"));       // нет
        System.out.println("+123".matches("(-|\\+)?\\d+")); // да
    }

}
