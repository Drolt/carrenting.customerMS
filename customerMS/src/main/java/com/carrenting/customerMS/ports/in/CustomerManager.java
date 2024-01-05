package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.ports.data.Customer;

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
}
