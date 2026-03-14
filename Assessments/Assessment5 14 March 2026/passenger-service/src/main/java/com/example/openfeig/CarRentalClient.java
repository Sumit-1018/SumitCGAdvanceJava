package com.example.openfeig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Client side load balancing is automatically handled by Spring Cloud LoadBalancer backing Feign
@FeignClient(name = "car-rental-service") 
public interface CarRentalClient {
    @GetMapping("/cars/{id}")
    Object getCarById(@PathVariable("id") Long id);
}