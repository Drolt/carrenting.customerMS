package com.carrenting.customerMS.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//Reservierungen darzustellen, die vom Microservice "Reservation" abgerufen werden.
public class ReservationDto {
    private int reservationID;
    private Date startDate;
    private Date endDate;
    private int customerID;
    private int carID;
}
