package com.authorws.app.model.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD })
@Constraint(validatedBy=FirstNameValidator.class)
public @interface FirstName {
	
	String message() default "First Name should start with uppercase";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
