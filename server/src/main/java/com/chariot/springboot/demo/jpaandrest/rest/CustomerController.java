package com.chariot.springboot.demo.jpaandrest.rest;

import com.chariot.springboot.demo.jpaandrest.domain.Customer;
import com.chariot.springboot.demo.jpaandrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/customer")
public class CustomerController {
  private CustomerRepository customerRepository;

  @Autowired
  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @RequestMapping("")
  @ResponseBody Iterable<Customer> getAllCustomers() {
    return this.customerRepository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  Optional<Customer> getCustomerById(@PathVariable(name = "id") Long id) {
    return this.customerRepository.findById(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  Customer saveCustomer(@RequestBody Customer customer) {
    return this.customerRepository.save(customer);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  void deleteCustomer(@PathVariable(name = "id") Long id) {
    this.customerRepository.deleteById(id);
  }

}
