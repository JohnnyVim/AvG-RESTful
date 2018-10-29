package de.hska.customer;

import de.hska.customer.entity.Customer;
import de.hska.customer.rest.CustomerHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class CustomerApplication {
    private static CustomerHandler handler = new CustomerHandler();

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> findAll() {
        return handler.findAll();
    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET, params = {"firstName", "lastName"})
    public ResponseEntity<Customer> findByName(@RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName) {
        return handler.findByName(firstName, lastName);
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Boolean> add(@RequestBody Customer customer) {
        return handler.add(customer);
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST, params = { "credit"})
    public ResponseEntity<Boolean> isCreditWorthy(@RequestBody Customer customer, @RequestParam("credit") Double credit) {
        return handler.isCreditWorthy(customer, credit);
    }

}
