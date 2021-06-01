package com.mohtasimtest.thinkificweather.repositories;

import com.mohtasimtest.thinkificweather.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByUsername(String username);
    Customer getById(Long id);
}
