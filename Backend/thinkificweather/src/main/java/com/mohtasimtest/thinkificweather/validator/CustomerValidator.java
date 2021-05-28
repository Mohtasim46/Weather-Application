package com.mohtasimtest.thinkificweather.validator;

import com.mohtasimtest.thinkificweather.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Customer customer = (Customer) object;

        if(customer.getPassword().length() < 6) {
            errors.rejectValue("password", "length", "Password length must be at least 6 characters.");
        }

        if(customer.getPassword().equals(customer.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Match", "Password must match");
        }
    }
}
