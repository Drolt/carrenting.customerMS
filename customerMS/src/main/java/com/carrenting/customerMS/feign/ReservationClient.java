package com.carrenting.customerMS.feign;

import com.carrenting.customerMS.dto.ReservationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8083")
public interface ReservationClient {

    //Alle Reservierungen anzeigen
    //GET: http://localhost:8081/api/employees/reservation
    @GetMapping("/api/reservation")
    List<ReservationDto> getAllReservations();


    //Neue Reservierung
    //POST: http://localhost:8081/api/employees/reservation
    //JSON: {"customerId": 1, "carId": 1, "startDate": "2023-07-01T10:00:00", "endDate": "2023-07-03T15:00:00" }
    @PostMapping("/api/reservation")
    ReservationDto addReservation(ReservationDto reservation);


    //Reservierung nach ID Loeschen
    // DELETE: http://localhost:8081/api/employees/reservation/12
    @DeleteMapping("/api/reservation/{id}")
    void deleteReservation(@PathVariable("id") Long id);


    //Reservierung fuer einen Fahrzeig nach CARID nasehen
    // GET: http://localhost:8081/api/employees/reservation/vehicle?carID=3
    @GetMapping("/api/reservation/vehicle")
    List<ReservationDto> getReservationsForVehicle(@RequestParam("carID") int carID);
}
