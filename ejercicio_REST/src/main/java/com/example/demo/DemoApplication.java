package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication {

    // start everything
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
  }

    // run this only on profile 'demo', avoid run this in test
    // @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(PaisRepository repository) {
        return args -> {
            repository.save(new Pais("Afghanistan", "Kabul", new BigDecimal(652230.0), 27657145));
            repository.save(new Pais("Albania", "Tirana", new BigDecimal(28748.0), 2886026));
            repository.save(new Pais("Andorra", "Andorra la Vella", new BigDecimal(468.0), 78014));
        };
    }
}
