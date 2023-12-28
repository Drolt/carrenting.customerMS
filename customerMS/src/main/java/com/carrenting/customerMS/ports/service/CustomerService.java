package com.carrenting.customerMS.ports.service;

import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerManager;
import com.carrenting.customerMS.ports.out.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class CustomerService implements CustomerManager {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer signUpCustomer(Customer customer) {
        return CustomerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
