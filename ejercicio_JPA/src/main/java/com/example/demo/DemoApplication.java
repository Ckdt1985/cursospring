package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers "John Woo", "Jeff Dean", "Josh Bloch", "Josh Long"
      repository.save(new Customer("John", "Woo"));
      repository.save(new Customer("Jeff", "Dean"));
      repository.save(new Customer("Josh", "Bloch"));
      repository.save(new Customer("Josh", "Long"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");      
      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");
      // fetch customers by last name
      log.info("Customer found with findByFirstName('Josh'):");
      log.info("--------------------------------------------");
      repository.findByFirstName("Josh").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }
}
