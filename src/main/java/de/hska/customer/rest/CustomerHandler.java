package de.hska.customer.rest;

import de.hska.customer.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerHandler {
    private List<Customer> customers;

    public CustomerHandler() {
        customers = new ArrayList<>();
        customers.add(new Customer("Manuel", "Neuer", 1000));
        customers.add(new Customer("Ariane", "Alpha", 2000));
        customers.add(new Customer("Benno", "Beta", 500));
    }

    public ResponseEntity<List<Customer>> findAll() {
        if (emptyCustomers()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    public ResponseEntity<Customer> findByName(String firstName, String lastName) {
        if (emptyCustomers()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Customer temp = findCustomer(firstName, lastName);
        if (temp == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> add(Customer customer) {
        Customer temp = findCustomer(customer);
        if (temp != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        customers.add(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Boolean> isCreditWorthy(Customer customer, double credit) {
        if (customer.getLimit() > credit)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private boolean emptyCustomers() {
        return (customers == null || customers.isEmpty());
    }

    private Customer findCustomer(String firstName, String lastName) {
        if (emptyCustomers()) return null;
        List<Customer> temp = customers.stream().filter(x -> x.getFirstName().equals(firstName)
                && x.getLastName().equals(lastName)).collect(Collectors.toList());
        if (temp.size() != 1) return null;
        return temp.get(0);
    }

    private Customer findCustomer(Customer customer) {
        return findCustomer(customer.getFirstName(), customer.getLastName());
    }

}
