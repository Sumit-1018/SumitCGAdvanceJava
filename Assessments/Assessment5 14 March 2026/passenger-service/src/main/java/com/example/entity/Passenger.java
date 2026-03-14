package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {
    @Id
    private Long id;
    private String name;
    private Long allocatedCarId;

    public Passenger() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getAllocatedCarId() { return allocatedCarId; }
    public void setAllocatedCarId(Long allocatedCarId) { this.allocatedCarId = allocatedCarId; }
}