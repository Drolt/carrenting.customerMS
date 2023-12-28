package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.ports.data.Customer;

import java.util.List;

public interface CustomerManager {

    Customer signUpCustomer(Customer customer);
    List<Customer> getAllCustomers();


}
