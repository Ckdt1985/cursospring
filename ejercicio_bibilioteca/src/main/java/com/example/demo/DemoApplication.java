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
    CommandLineRunner initDatabase(BookRepository bookRepository, UserRepository userRepository, FondoLibroRepository fondo) {
        return args -> {
            bookRepository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", "REF001"));
            bookRepository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", "REF002"));
            bookRepository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "REF003"));

            userRepository.save(new User("Daniel", "Rojo", 0000001));
            fondo.save(new FondoLibro(1L, 0));

        };
    }
}
