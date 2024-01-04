package com.carrenting.customerMS.adapters.in;

import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerManager customerManager;

    @Autowired
    public CustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @PostMapping    //JSON http://localhost:8082/api/customer
    // {"firstName": "Max","lastName": "Mustermann","email": "test@gmx.de","password": "123"}
    public ResponseEntity<Customer> signUpCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerManager.signUpCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        customerManager.deleteCustomerById(customerId);
        return  ResponseEntity.ok().build();
    }

}

