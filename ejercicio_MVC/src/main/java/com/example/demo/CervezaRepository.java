package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CervezaRepository extends JpaRepository<Cerveza, Long> {
}
