package com.chariot.springboot.demo.jpaandrest.repository;

import com.chariot.springboot.demo.jpaandrest.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
