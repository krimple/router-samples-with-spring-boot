package com.chariot.springboot.demo.jpaandrest.rest;

import com.chariot.springboot.demo.jpaandrest.domain.Customer;
import com.chariot.springboot.demo.jpaandrest.repository.CustomerRepository;
import org.assertj.core.util.IterableUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class CustomerControllerTests {


  @Autowired
  private TestRestTemplate template;

  @MockBean
  private CustomerRepository customerRepository;

  @Before
  public void setup() {
    given(this.customerRepository.findAll())
      .willReturn(IterableUtil.iterable(new Customer(1L, "Ken", "Rimple")));
  }
  @Test
  public void testGetAllCustomers() throws Exception {
    ResponseEntity<Customer[]> response = this.template.getForEntity("/customer", Customer[].class);
    Customer[] customers = response.getBody();
    HttpStatus statusCode = response.getStatusCode();
    MediaType mediaType = response.getHeaders().getContentType();
    assertEquals(customers.length, 1);
    assertEquals(statusCode, HttpStatus.OK);
    assertEquals(mediaType, MediaType.APPLICATION_JSON_UTF8);
  }
}
