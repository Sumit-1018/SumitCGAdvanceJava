package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.entity.Car;
import com.example.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Car getCarDetails(@PathVariable Long id) {
        return repository.findById(id).orElse(new Car(id, "Unknown", "Not Found"));
    }
    
    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return repository.save(car);
    }
}