package com.example.validatinginputform.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class User implements Validator {
    @NotEmpty(message = "this field cannot be empty")
    @Size(min = 2, max = 30)
    private String name;

    @Min(value = 18, message = "You are too young")
    private int age;

    private String number;

    public User() {
    }

    public User(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User phoneNumber = (User) target;
        String number = phoneNumber.getNumber();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty","Khong duoc de trong");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
        if(number.isEmpty()|number.equals("")) {
            errors.rejectValue("number","number.empty");
        }
    }
}

