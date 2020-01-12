package com.novatec.chaosapppersons.entities;

import org.springframework.data.mongodb.core.index.Indexed;

public class Person {

    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {}

    @Override
    public String toString() {
        return String.format("Person[Firstname: %s, Lastname: %s, Email: %s]", firstName, lastName, email);
    }
}
