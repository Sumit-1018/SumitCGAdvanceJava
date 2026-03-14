package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Car;
public interface CarRepository extends JpaRepository<Car, Long> {}