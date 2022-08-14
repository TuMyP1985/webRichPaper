package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.web.utils.ExecutValue.*;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {

        instance();

        SpringApplication.run(WebApplication.class, args);

    }

}
