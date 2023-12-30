package com.carrenting.customerMS.ports.service;

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

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer signUpCustomer(Customer customer) {
        return customerRepository.save(customer);
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

    @Override
    public  Customer updateCustomerEmail(Integer customerId, String eMail, Customer newCustomerData) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Id not found"));
        customer.setEmail(newCustomerData.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public  Customer updateCustomerPassword(Integer customerId, String password, Customer newCustomerData) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Id not found"));
        customer.setPassword(newCustomerData.getPassword());
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteByCustomerId(customerId);
    }

}
