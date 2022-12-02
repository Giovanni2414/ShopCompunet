package com.icesi.edu.Shop.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

public interface CustomAnnotations {

    @Documented
    @Constraint(validatedBy = NameValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface NameValidation {


        String message() default "Name is invalid";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

    @Documented
    @Constraint(validatedBy = EmailValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface EmailValidation {


        String message() default "Email is invalid";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

    @Documented
    @Constraint(validatedBy = PasswordValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface PasswordValidation {


        String message() default "Password must have at least 6 characters";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

    @Documented
    @Constraint(validatedBy = PhoneValidator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface PhoneValidation {


        String message() default "Phone number must have at least 10 characters";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }
}