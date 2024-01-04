package com.carrenting.customerMS.ports.out;

import com.carrenting.customerMS.ports.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(Integer customerId);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);
    void deleteByCustomerId(Integer customerId);
}

