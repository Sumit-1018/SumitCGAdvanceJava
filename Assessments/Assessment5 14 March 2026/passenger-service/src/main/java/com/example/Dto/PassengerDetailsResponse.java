package com.example.Dto;

import com.example.entity.Passenger;

public class PassengerDetailsResponse {
    private Passenger passenger;
    private Object carDetails;

    public PassengerDetailsResponse(Passenger passenger, Object carDetails) {
        this.passenger = passenger;
        this.carDetails = carDetails;
    }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public Object getCarDetails() { return carDetails; }
    public void setCarDetails(Object carDetails) { this.carDetails = carDetails; }
}