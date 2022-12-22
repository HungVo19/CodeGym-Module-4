package com.example.registerform.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "this field cannot be blank")
    @Size(min = 5, max = 45, message = "size 5 -45")
    private String firstName;
    @NotBlank(message = "this field cannot be blank")
    @Size(min = 5, max = 45, message = "size 5 -45")
    private String lastName;
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "not a valid number")
    private String phoneNumber;
    @Min(value = 18, message = "you are too young")
    private Integer age;
    @Email(message = "not a valid email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
