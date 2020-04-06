package com.maskibail.service.customer.repository;

import com.maskibail.service.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(long id);

    List<Customer> findByLastName(String lastName);
}
