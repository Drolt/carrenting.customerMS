package com.carrenting.customerMS.ports.in;

import com.carrenting.customerMS.ports.data.Customer;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerManager {

    Customer signUpCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer updateCustomerEmail(Integer customerId, String eMail, Customer newCustomerData);
    Customer updateCustomerPassword(Integer customerId, String password, Customer newCustomerData);
    @Transactional
    void deleteCustomerById(Integer customerId);
}
