package com.mohtasimtest.thinkificweather.controllers;

import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.services.CustomerService;
import com.mohtasimtest.thinkificweather.services.ErrorValidationService;
import com.mohtasimtest.thinkificweather.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private ErrorValidationService errorValidationService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
        // validate password match
        customerValidator.validate(customer, result);

        ResponseEntity<?> errorMap = errorValidationService.getErrorMapAfterValidation(result);
        if(errorMap != null) return errorMap;

        Customer newCustomer = customerService.saveCustomer(customer);

        return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
    }


}
