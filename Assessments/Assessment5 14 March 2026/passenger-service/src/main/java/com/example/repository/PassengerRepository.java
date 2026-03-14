package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Passenger;
public interface PassengerRepository extends JpaRepository<Passenger, Long> {}