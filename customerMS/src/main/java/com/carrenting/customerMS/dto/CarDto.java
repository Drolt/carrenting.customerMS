package com.carrenting.customerMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Fuer Fahrzeugdaten darzustellen, die vom Microservice "car" abgerufen werden.
public class CarDto {   // Car Data Transfer Object
    private int carID;
    private String licensePlate;
    private Integer mileage;
    private String brand;
    private String model;
}
