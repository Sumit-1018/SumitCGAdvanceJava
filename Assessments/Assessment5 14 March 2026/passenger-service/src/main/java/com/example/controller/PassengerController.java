package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.Dto.PassengerDetailsResponse;
import com.example.entity.Passenger;
import com.example.openfeig.CarRentalClient;
import com.example.repository.PassengerRepository;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerRepository repository;
    private final CarRentalClient carClient;

    public PassengerController(PassengerRepository repository, CarRentalClient carClient) {
        this.repository = repository;
        this.carClient = carClient;
    }

    @GetMapping("/{id}")
    public PassengerDetailsResponse getPassengerInfo(@PathVariable Long id) {
        Passenger passenger = repository.findById(id).orElseThrow();
        Object carDetails = carClient.getCarById(passenger.getAllocatedCarId());
        return new PassengerDetailsResponse(passenger, carDetails);
    }
    
    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return repository.save(passenger);
    }
}