package com.example.passengerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.entity")
@EnableFeignClients(basePackages = "com.example.openfeig")
public class PassengerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassengerServiceApplication.class, args);
    }
}