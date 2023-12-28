package com.carrenting.customerMS.ports.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public Customer(Integer customerId, String firstName, String lastName, String email, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}


