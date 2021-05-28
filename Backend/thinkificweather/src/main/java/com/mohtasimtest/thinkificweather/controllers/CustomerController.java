package com.mohtasimtest.thinkificweather.controllers;

import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.payload.JwtLoginSuccessResponse;
import com.mohtasimtest.thinkificweather.payload.LoginRequest;
import com.mohtasimtest.thinkificweather.security.JwtTokenProvider;
import com.mohtasimtest.thinkificweather.services.CustomerService;
import com.mohtasimtest.thinkificweather.services.ErrorValidationService;
import com.mohtasimtest.thinkificweather.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.mohtasimtest.thinkificweather.contracts.SecurityContracts.TOKEN_PREFIX;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private ErrorValidationService errorValidationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
        // validate password match
        customerValidator.validate(customer, result);

        ResponseEntity<?> errorMap = errorValidationService.getErrorMapAfterValidation(result);
        if(errorMap != null) return errorMap;

        Customer newCustomer = customerService.saveCustomer(customer);

        return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateCustomer(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.getErrorMapAfterValidation(result);
        if(errorMap != null)return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + jwtTokenProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt));
    }


}
