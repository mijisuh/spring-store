package ssd0206.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ssd0206.controller.AccountForm;
import ssd0206.domain.Account;

@Component
public class AccountFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AccountForm accountForm = (AccountForm)obj; 
		Account account = accountForm.getAccount();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.accountName", "ACCOUNT_NAME_REQUIRED", "Account Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.password", "PASSWORD_REQUIRED", "password is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.username", "USERNAME_REQUIRED", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phone", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address1", "ADDRESS_REQUIRED", "Address (1) is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.city", "CITY_REQUIRED", "City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.state", "STATE_REQUIRED", "State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.zip", "ZIP_REQUIRED", "ZIP is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.country", "COUNTRY_REQUIRED", "Country is required.");
		
		if (accountForm.isNewAccount()) {
//			account.setStatus("OK");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.accountName", "ACCOUNT_NAME_REQUIRED", "Account Name is required.");
			if (account.getPassword() == null || account.getPassword().length() < 1 ||
					!account.getPassword().equals(accountForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		} else {
			if(!account.getPassword().equals(accountForm.getRepeatedPassword()))
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
		}
		
	}
}