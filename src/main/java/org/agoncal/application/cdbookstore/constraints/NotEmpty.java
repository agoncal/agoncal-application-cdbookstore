package org.agoncal.application.cdbookstore.constraints;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import javax.validation.Payload;
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
		ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Documented
public @interface NotEmpty {

	String message() default "Invalid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
			ElementType.TYPE, ElementType.ANNOTATION_TYPE,
			ElementType.CONSTRUCTOR})
	public @interface List {
		NotEmpty[] value();
	}
}