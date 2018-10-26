package de.hska.customer.entity;

public class Customer {
    private static long idCounter = 0;

    private long id;
    private String firstName;
    private String lastName;
    private double credit;

    public Customer() {
        this.id = idCounter++;
    }

    public Customer(String firstName, String lastName, double credit) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getCredit() {
        return credit;
    }
}
