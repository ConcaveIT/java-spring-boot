package com.advpro.payment.validator;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.validation.Validator;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.springframework.stereotype.Component;

@Component
public class DtoValidator<T> {

	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private final Validator validator = factory.getValidator();


	public String validate(T objDto) {
		Set<ConstraintViolation<T>> violations = validator.validate(objDto);
		String outcome = "";

		if (!violations.isEmpty()) {
			Set<String> errorMsgs = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
			outcome = String.join("\n", errorMsgs);
		}

		return outcome;
	}

}