package com.brandon;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, message = "First name must contain at least one character")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, message = "Last name must contain at least one character")
    private String lastName;

    @Min(value = 0, message = "Free passes must be equal to or greater than 0")
    @Max(value = 10, message = "Free passes must be equal to or less than 10")
    private int freePasses;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
