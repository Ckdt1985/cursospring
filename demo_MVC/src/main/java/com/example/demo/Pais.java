package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Pais {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String capital;
    private BigDecimal area;
    private Integer poblacion;

    // avoid this "No default constructor for entity"
    public Pais() {
    }

    public Pais(Long id, String nombre, String capital, BigDecimal area, Integer poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.area = area;
        this.poblacion = poblacion;
    }

    public Pais(String nombre, String capital, BigDecimal area, Integer poblacion) {
        this.nombre = nombre;
        this.capital = capital;
        this.area = area;
        this.poblacion = poblacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", capital='" + capital + '\'' +
                ", area=" + area + '\'' +
                ", poblacion=" + poblacion + 
            '}';
    }

}
