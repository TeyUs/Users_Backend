package com.example.ogrBackend.validator;

import com.example.ogrBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUserName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsUserByUserName(userName);
    }
}
