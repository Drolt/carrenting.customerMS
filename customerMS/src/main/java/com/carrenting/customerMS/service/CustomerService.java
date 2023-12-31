package com.carrenting.customerMS.service;

import com.carrenting.customerMS.dto.CarDto;
import com.carrenting.customerMS.dto.ReservationDto;
import com.carrenting.customerMS.feign.ReservationClient;
import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerManager;
import com.carrenting.customerMS.ports.out.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerManager {


    private CustomerRepository customerRepository;
    private ReservationClient reservationClient;


    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           ReservationClient reservationClient){
        this.customerRepository = customerRepository;
        this.reservationClient = reservationClient;
    }


    @Override
    @Transactional
    public Customer signUpCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> logInCustomer(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getCustomer(Integer customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    @Transactional //(readOnly = true)-
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomerEmail(String oldEmail, String newEmail) {
        Customer customer = customerRepository.findByEmail(oldEmail).orElseThrow(() -> new RuntimeException("Customer with old email not found"));

        customer.setEmail(newEmail);
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void changeCustomerPassword(String email, String oldPassword, String newPassword) {
        Customer customer = customerRepository.findByEmailAndPassword(email, oldPassword).orElseThrow(() -> new RuntimeException("Invalid credentials"));

        customer.setPassword(newPassword); // Make sure to encrypt the password if necessary
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteByCustomerId(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomerByEmailAndPassword(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent() && customer.get().getPassword().equals(password)) {
            customerRepository.delete(customer.get());
        } else {
            throw new RuntimeException("Invalid credentials provided");
        }
    }



    //======================================[Reservations]====================================================
    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationClient.getAllReservations();
    }


    @Override
    public ReservationDto addReservation(ReservationDto reservation) {
        return reservationClient.addReservation(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationClient.deleteReservation(reservationId);
    }

    public List<ReservationDto> getReservationsForVehicle(int carID) {
        return reservationClient.getReservationsForVehicle(carID);
    }

    @Override
    public List<CarDto> getAvailableVehicles() {
        return reservationClient.getAvailableVehicle();
    }

    @Override
    public List<ReservationDto> getAllReservationsByUserID(int userID) {
        return reservationClient.getAllReservationsByUserID(userID);
    }

}
