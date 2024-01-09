package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.dto.CarDto;
import com.carrenting.customerMS.dto.ReservationDto;
import com.carrenting.customerMS.ports.data.Customer;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CustomerManager {

    Customer signUpCustomer(Customer customer);

    Optional<Customer> logInCustomer(String email, String password);

    Optional<Customer> getCustomer(Integer customerId);

    List<Customer> getAllCustomers();

    void updateCustomerEmail(String oldEmail, String newEmail);

    void changeCustomerPassword(String email, String oldPassword, String newPassword);

    void deleteCustomerById(Integer customerId);

    void deleteCustomerByEmailAndPassword(String email, String password);


    //======================================[Reservations]====================================================
    List<ReservationDto> getAllReservations();
    ReservationDto addReservation(ReservationDto reservation);
    void deleteReservation(Long reservationId);
    List<ReservationDto> getReservationsForVehicle(@RequestParam("carID") int carID);
    List<CarDto> getAvailableVehicles();
    List<ReservationDto> getAllReservationsByUserID(int userID);

}
