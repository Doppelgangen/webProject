package com.vik.model;

import javax.validation.constraints.*;

public class BaseUnit {

    private int id;

    @Min(value = 0, message = "Age should be be between 0 and 120")
    @Max(value = 120, message = "Age should be be between 0 and 120")
    private int age;

    @NotEmpty(message = "Name should be valid")
    @Size(min = 0, max = 50, message = "Name should be less than 50 characters")
    private String name;

    @NotEmpty(message = "Surname should be valid")
    @Size(min = 0, max = 50, message = "Surname should be less than 50 characters")
    private String surname;

    @NotEmpty(message = "Email should be valid")
    @Email(message = "Email should be valid")
    private String email;

    public BaseUnit() {
    }

    public BaseUnit(int id,
                    int age,
                    String name,
                    String surname,
                    String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
