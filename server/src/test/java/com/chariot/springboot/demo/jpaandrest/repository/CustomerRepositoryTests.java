package com.chariot.springboot.demo.jpaandrest.repository;

import com.chariot.springboot.demo.jpaandrest.domain.Customer;
import com.chariot.springboot.demo.jpaandrest.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void setup() {
      Customer c = new Customer(null, "Joe", "Developer");
      this.entityManager.persist(c);
      this.entityManager.flush();
    }
    @Test
    public void testGetAllCustomers() {
      Iterable<Customer> customers = this.customerRepository.findAll();
      customers.forEach((Customer customer) -> System.out.println("${customer}"));
    }
  }
