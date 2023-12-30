package com.carrenting.customerMS.adapters.in;

import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerManager customerManager;

    @Autowired
    public CustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @PostMapping//JSON
    public ResponseEntity<Customer> signUpCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerManager.signUpCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

}

