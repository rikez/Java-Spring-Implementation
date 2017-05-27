package br.skynar.api.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.skynar.api.Entity.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "dob", "field.required");

	}

}
