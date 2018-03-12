package com.chariot.springboot.demo.jpaandrest.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Customer {

  public Customer(Long id, String lastName, String firstName) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public Customer() {

  }

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name")
  private String firstName;

  public Long getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
