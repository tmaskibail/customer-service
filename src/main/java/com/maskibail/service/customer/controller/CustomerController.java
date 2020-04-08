package com.maskibail.service.customer.controller;

import com.maskibail.service.customer.exception.CustomerNotFoundException;
import com.maskibail.service.customer.model.Customer;
import com.maskibail.service.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class CustomerController {

    public static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/customers/{id}")
    public @ResponseBody
    Customer getCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException {
        LOG.info("Received request for customer id {}", id);
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            LOG.info("Customer with id {} was not found!", id);
            throw new CustomerNotFoundException();
        }
        return customer.get();
    }

    @PostMapping(path = "/customers/add")
    public @ResponseBody
    Customer addNewCustomer(
            @RequestParam String title,
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String lastName,
            @RequestParam Date dob
    ) {
        Customer customer = new Customer(title, firstName, middleName, lastName, dob, new Date());
        customerRepository.save(customer);

        LOG.info("Persisted user {}, {} with id {} successfully", firstName, lastName, customer.getId());
        return customer;
    }

    @GetMapping(path = "/customers/all")
    public @ResponseBody
    Iterable<Customer> getAll() {
        LOG.info("Received request to fetch all customers...");
        return customerRepository.findAll();
    }
}
