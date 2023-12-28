package com.carrenting.customerMS.ports.out;

import com.carrenting.customerMS.ports.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    void deleteByCustomerId(Integer customerId);
    Optional<Customer> findByCustomerId(Integer customerId);
}

