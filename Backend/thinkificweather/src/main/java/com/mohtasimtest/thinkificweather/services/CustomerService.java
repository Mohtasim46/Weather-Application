package com.mohtasimtest.thinkificweather.services;

import com.mohtasimtest.thinkificweather.exceptions.UsernameAlreadyExistsException;
import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Customer saveCustomer(Customer newCustomer) {
        try{
            newCustomer.setPassword(bCryptPasswordEncoder.encode(newCustomer.getPassword()));

            //Username has to be unique(exception)
            newCustomer.setUsername(newCustomer.getUsername());

            //Make sure password & confirm password matches
            //We dont persist or show the confirm password
            newCustomer.setConfirmPassword("");
            return customerRepository.save(newCustomer);
        }catch (Exception exception) {
            throw new UsernameAlreadyExistsException("Username '" + newCustomer.getUsername()
                    + "' already exists.");
        }
    }
}
