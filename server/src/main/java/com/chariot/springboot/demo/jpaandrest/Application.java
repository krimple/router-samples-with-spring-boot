package com.chariot.springboot.demo.jpaandrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.chariot.springboot.demo.jpaandrest.domain"})  // scan JPA entities
@ComponentScan
@EnableAutoConfiguration
public class Application {

  private static ConfigurableApplicationContext applicationContext;

  public static void main(String[] args) {
    Application.applicationContext = SpringApplication.run(Application.class, args);
  }
}
