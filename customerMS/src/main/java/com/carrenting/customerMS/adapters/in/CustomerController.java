package com.carrenting.customerMS.adapters.in;

import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        // Implement signup logic
    }

    @PostMapping("/login")
    public void login(@RequestBody Customer customer) {
        // Implement login logic
    }
}

