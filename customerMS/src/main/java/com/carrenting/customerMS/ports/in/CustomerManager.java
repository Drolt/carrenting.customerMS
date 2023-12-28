package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.ports.data.Customer;

import java.util.List;

public interface CustomerManager {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
