package com.relyits.rmbs.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.relyits.rmbs.beans.registration.RegistrationBean;

public class UserRegistrationValidator implements Validator{

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	String ID_PATTERN = "[0-9]+";  
	String STRING_PATTERN = "[a-zA-Z]+";  
	String MOBILE_PATTERN = "[0-9]{10}";  

	@Override
	public boolean supports(Class cls) {
		// TODO Auto-generated method stub
		return RegistrationBean.class.isAssignableFrom(cls);
	}
	@Override
	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required", "Firstname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required", "Lastname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required", "confirmPassword is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required", "Dateofbirth is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Shop name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tinNo", "tinNo.required", "Tin number is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required", "Gender is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressBean.mobile", "addressBean.mobile.required", "Mobile number is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressBean.email", "addressBean.email.required", "EmailId is  required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressBean.address", "addressBean.address.required", "Address is required");


		RegistrationBean registrationBean = (RegistrationBean) target;

		if(!registrationBean.getPassword().equals(registrationBean.getConfirmPassword()))
		{
			errors.rejectValue("confirmPassword", "confirmPassword.notmatch", "Password did not match");
		}
		if (!(registrationBean.getFirstName() != null && registrationBean.getFirstName().isEmpty())) {  
			pattern = Pattern.compile(STRING_PATTERN);  
			matcher = pattern.matcher(registrationBean.getFirstName());  
			if (!matcher.matches()) {  
				errors.rejectValue("firstName", "firstName.containNonChar",  
						"Enter a valid name");  
			}  
		}
		if (!(registrationBean.getLastName() != null && registrationBean.getLastName().isEmpty())) {  
			pattern = Pattern.compile(STRING_PATTERN);  
			matcher = pattern.matcher(registrationBean.getLastName());  
			if (!matcher.matches()) {  
				errors.rejectValue("lastName", "lastName.containNonChar",  
						"Enter a valid name");  
			}  
		} 
		if(!(registrationBean.getAddressBean().getEmail()!= null && registrationBean.getAddressBean().getEmail().isEmpty())){
			pattern=pattern.compile(EMAIL_PATTERN);
			matcher=pattern.matcher(registrationBean.getAddressBean().getEmail());
			if(!matcher.matches())
			{
				errors.rejectValue("addressBean.email","addressBean.email.incorrect", "Enter correct email");
			}
		}
		if((registrationBean.getAddressBean().getMobile()!= null))
		{
			String s = String.valueOf(registrationBean.getAddressBean().getMobile());
			pattern=pattern.compile(MOBILE_PATTERN);
			matcher=pattern.matcher(s);
			if(!matcher.matches())
			{
				errors.rejectValue("addressBean.mobile", "addressBean.mobile.incorrect", "Enter correct mobile number");
			}
		}
		/*if(!(registrationBean.getTinNo()!=null && registrationBean.getTinNo().isEmpty()))
		{
			pattern=pattern.compile(MOBILE_PATTERN);
			matcher=pattern.matcher(registrationBean.getTinNo());
			if(!matcher.matches())
			{
				errors.rejectValue("tinNo", "tin.containNonNum", "tin number should contain numbers");
			}
		}*/
		if(!(registrationBean.getName()!= null && registrationBean.getName().isEmpty()))
		{
			pattern=pattern.compile(STRING_PATTERN);
			matcher=pattern.matcher(registrationBean.getName());
			if(!matcher.matches())
			{
				errors.rejectValue("name", "name.shopNameNonNum", "Shopname should contain characters");
			}
		}
	}
}
