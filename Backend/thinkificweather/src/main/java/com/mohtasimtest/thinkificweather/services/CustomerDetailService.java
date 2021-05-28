package com.mohtasimtest.thinkificweather.services;

import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(s);

        if(customer == null) new UsernameNotFoundException("Customer not found !!");
        return customer;
    }

    @Transactional
    public Customer loadUserById(Long id) throws UsernameNotFoundException {
        Customer customer = customerRepository.getById(id);
        if(customer == null) new UsernameNotFoundException("Customer not found !!");
        return customer;
    }
}
