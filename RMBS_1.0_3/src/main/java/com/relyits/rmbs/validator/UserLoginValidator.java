package com.relyits.rmbs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.relyits.rmbs.beans.registration.RegistrationBean;

public class UserLoginValidator implements Validator {

	@Override
	public boolean supports(Class cls) {
		// TODO Auto-generated method stub
		return RegistrationBean.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.login.required", "Enter your username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.login.required","Enter your password");
	}
	
}
