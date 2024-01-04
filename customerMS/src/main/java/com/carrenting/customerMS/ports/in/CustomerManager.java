package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.ports.data.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerManager {

    Customer signUpCustomer(Customer customer);
    Optional<Customer> logInCustomer(String email, String password);
    Optional<Customer> getCustomer(Integer customerId);
    List<Customer> getAllCustomers();
    Customer updateCustomerEmail(Integer customerId, String eMail, Customer newCustomerData);
    Customer updateCustomerPassword(Integer customerId, String password, Customer newCustomerData);
    void deleteCustomerById(Integer customerId);
}
