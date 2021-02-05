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
    CommandLineRunner initDatabase(PaisRepository paisRepository, ApodRepository apodRepository, CervezaRepository cervezasRepository) {
        return args -> {

            paisRepository.save(new Pais("Afghanistan", "Kabul", new BigDecimal(652230.0), 27657145));
            paisRepository.save(new Pais("Albania", "Tirana", new BigDecimal(28748.0), 2886026));
            paisRepository.save(new Pais("Andorra", "Andorra la Vella", new BigDecimal(468.0), 78014));
            
            apodRepository.save(new Apod(
              "Astronomy Picture of the Day", 
              " Fifty years ago this Friday, Apollo 14's Lunar Module Antares landed on the Moon.",
              "4/2/2021", 
              "https://apod.nasa.gov/apod/image/2102/a14pan9335-43emj_900.jpg"));

            cervezasRepository.save(new Cerveza(
              "Buzz", 
              "A Real Bitter Experience.",
              "https://images.punkapi.com/v2/keg.png", 
              4.5));

            cervezasRepository.save(new Cerveza(
              "Trashy Blonde", 
              "You Know You Shouldn't",
              "https://images.punkapi.com/v2/2.png", 
              4.1));

            cervezasRepository.save(new Cerveza(
              "Berliner Weisse With Yuzu - B-Sides", 
              "Japanese Citrus Berliner Weisse.",
              "https://images.punkapi.com/v2/keg.png", 
              4.2));
        };
    }
}
