package com.lovetocode.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCodePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.courseCodePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        if (courseCode != null) {
            return courseCode.startsWith(this.courseCodePrefix);
        }
        return true;
    }
}
