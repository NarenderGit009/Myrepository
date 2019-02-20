package com.relyits.rmbs.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans.registration.RegistrationBean;

public class DoctorRegistrationValidator implements Validator{

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
		return DoctorBean.class.isAssignableFrom(cls);
	}
	@Override
	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctorName", "doctorName.required", "DoctorName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualification", "qualification.required", "Qualification is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specialization", "specialization.required", "Specialization is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hospitalName", "hospitalName.required", "HospitalName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "initial", "initial.required", "Initial is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resourceBean.addressBean.mobile", "addressBean.mobile.required", "Mobile number is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resourceBean.addressBean.email", "addressBean.email.required", "EmailId is  required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resourceBean.addressBean.address", "addressBean.address.required", "Address is required");


		DoctorBean doctorBean = (DoctorBean) target;
		
		if (!(doctorBean.getDoctorName() != null && doctorBean.getDoctorName().isEmpty())) {  
			pattern = Pattern.compile(STRING_PATTERN);  
			matcher = pattern.matcher(doctorBean.getDoctorName() );  
			if (!matcher.matches()) {  
				errors.rejectValue("doctorName", "doctorName.containNonChar",  
						"Enter a valid name");  
			}  
		}
		
		if(!(doctorBean.getResourceBean().getAddressBean().getEmail()!= null && doctorBean.getResourceBean().getAddressBean().getEmail().isEmpty())){
			pattern=pattern.compile(EMAIL_PATTERN);
			matcher=pattern.matcher(doctorBean.getResourceBean().getAddressBean().getEmail());
			if(!matcher.matches())
			{
				errors.rejectValue("resourceBean.addressBean.email","addressBean.email.incorrect", "Enter correct email");
			}
		}
		if((doctorBean.getResourceBean().getAddressBean().getMobile()!= null))
		{
			String s = String.valueOf(doctorBean.getResourceBean().getAddressBean().getMobile());
			pattern=pattern.compile(MOBILE_PATTERN);
			matcher=pattern.matcher(s);
			if(!matcher.matches())
			{
				errors.rejectValue("resourceBean.addressBean.mobile", "addressBean.mobile.incorrect", "Enter correct mobile number");
			}
		}
		
		
	}
}
