package com.vik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class EntityUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Age should be valid")
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
    @Email
    private String email;

    public EntityUnit() {
    }

    public EntityUnit(@NotEmpty(message = "Age should be valid")
                    @Min(value = 0, message = "Age should be be between 0 and 120")
                    @Max(value = 120, message = "Age should be be between 0 and 120") int age,
                    @NotEmpty(message = "Name should be valid")
                    @Size(min = 0, max = 50, message = "Name should be less than 50 characters") String name,
                    @NotEmpty(message = "Surname should be valid")
                    @Size(min = 0, max = 50, message = "Surname should be less than 50 characters") String surname,
                    @NotEmpty(message = "Email should be valid")
                    @Email String email) {
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
