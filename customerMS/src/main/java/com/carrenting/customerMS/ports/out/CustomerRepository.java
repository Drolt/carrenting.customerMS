package com.carrenting.customerMS.ports.out;

import com.carrenting.customerMS.ports.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

