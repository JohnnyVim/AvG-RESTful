package de.hska.customer.entity;

public class Customer {
    private String firstName;
    private String lastName;
    private double limit;

    public Customer() {}

    public Customer(String firstName, String lastName, double limit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.limit = limit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getLimit() {
        return limit;
    }
}
