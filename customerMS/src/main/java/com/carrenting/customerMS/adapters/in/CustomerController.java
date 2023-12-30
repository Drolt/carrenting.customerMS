package com.carrenting.customerMS.adapters.in;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    /*private final CustomerManager customerManager;
    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    //GET: http://localhost:8080/api/customer
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomerss() {
        List<Customer> cars = customerManager.getAllCustomers();
        return ResponseEntity.ok(cars);
    }
    //GET: http://localhost:8080/api/cars/RRKHM777
    @GetMapping("/{licensePlate}")
    public ResponseEntity<Customer> getCar(@PathVariable String licensePlate) {
        Optional<Customer> customer = customerManager.getCustomer(licensePlate);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //POST: http://localhost:8080/api/cars
    //JSON: {"licensePlate": "RRKHM777","mileage": 1400,"brand": "PEUGOT","model": "311"} or with carID -> "carID" : 1
    @PostMapping//JSON
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carManager.addCar(car);
        return ResponseEntity.ok(newCar);
    }


    //PUT: http://localhost:8080/api/cars/RRKHM777
    //JSON: {"licensePlate": "RRKHM777","mileage": 1400,"brand": "PEUGOT","model": "311"}
    @PutMapping("/{licensePlate}")
    public ResponseEntity<Car> updateCar(@PathVariable String licensePlate, @RequestBody Car car) {
        Car updatedCar = carManager.updateCar(licensePlate, car);
        return ResponseEntity.ok(updatedCar);
    }


    //DELETE: http://localhost:8080/api/cars/HA1234
    @DeleteMapping("/{licensePlate}")
    public ResponseEntity<Void> deleteCar(@PathVariable String licensePlate) {
        carManager.deleteCarByLicensePlate(licensePlate);
        return ResponseEntity.ok().build();
    }*/
}

