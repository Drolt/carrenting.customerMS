package com.carrenting.customerMS.adapters.in;

import com.carrenting.customerMS.dto.CarDto;
import com.carrenting.customerMS.dto.ReservationDto;
import com.carrenting.customerMS.ports.data.Customer;
import com.carrenting.customerMS.ports.in.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerManager customerManager;

    @Autowired // Autowiring the CustomerManager interface for dependency injection
    public CustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    //JSON http://localhost:8082/api/customer
    // {"firstName": "Max","lastName": "Mustermann","email": "test@gmx.de","password": "123"}
    @PostMapping
    public ResponseEntity<Customer> signUpCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerManager.signUpCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> logInCustomer(@RequestBody Map<String, String> credentials) {
        Optional<Customer> customer = customerManager.logInCustomer(credentials.get("email"), credentials.get("password"));
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerManager.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/update-email")
    public ResponseEntity<?> updateCustomerEmail(@RequestBody Map<String, String> emailDetails) {
        try {
            customerManager.updateCustomerEmail(emailDetails.get("oldEmail"), emailDetails.get("newEmail"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changeCustomerPassword(@RequestBody Map<String, String> passwordDetails) {
        try {
            customerManager.changeCustomerPassword(passwordDetails.get("email"),
                    passwordDetails.get("oldPassword"),
                    passwordDetails.get("newPassword"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        customerManager.deleteCustomerById(customerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCustomerByEmailAndPassword(@RequestBody Map<String, String> credentials) {
        try {
            customerManager.deleteCustomerByEmailAndPassword(credentials.get("email"), credentials.get("password"));
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



    //======================================[Reservations]====================================================
    //Alle Reservierungen anzeigen
    //GET: http://localhost:8082/api/customer/reservation
    @GetMapping("/reservation")
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> reservations = customerManager.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    //Neue Reservierung
    //POST: http://localhost:8082/api/customer/reservation
    //JSON:  {"reservationID": 16, "startDate": "2024-01-01T10:00:00", "endDate": "2024-01-07T15:00:00", "customerID": 1, "carID": 4 }
    @PostMapping("/reservation")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationDto reservation) {
        ReservationDto addReservation = customerManager.addReservation(reservation);
        return ResponseEntity.ok(addReservation);
    }

    //Reservierung nach ID Loeschen
    //DELETE: http://localhost:8082/api/customer/reservation/5
    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        customerManager.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    //Reservierung fuer einen Fahrzeig nach CARID ansehen
    // GET: http://localhost:8082/api/customer/reservation/vehicle?carID=3
    @GetMapping("/reservation/vehicle")
    public ResponseEntity<List<ReservationDto>> getReservationsForVehicle(@RequestParam("carID") int carID) {
        List<ReservationDto> reservations = customerManager.getReservationsForVehicle(carID);
        return ResponseEntity.ok(reservations);
    }

    //GET: http://localhost:8082/api/customer/reservation/availableVehicle
    @GetMapping("/reservation/availableVehicle")
    public ResponseEntity<List<CarDto>> getAvailableVehicle() {
        List<CarDto> carDtoList = customerManager.getAvailableVehicles();
        return ResponseEntity.ok(carDtoList);
    }

}

