package com.mohtasimtest.thinkificweather.services;

import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }
}
