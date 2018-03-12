package com.chariot.springboot.demo.jpaandrest.domain;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Course {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String description;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
