package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApodRepository extends JpaRepository<Apod, Long> {
}
