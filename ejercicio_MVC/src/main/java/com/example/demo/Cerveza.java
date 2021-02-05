package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cerveza {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String tagline;
    private double alcohol;
    private String url;

    // avoid this "No default constructor for entity"
    public Cerveza() {
    }

    public Cerveza(Long id, String nombre, String tagline, String url, double alcohol) {
        this.id = id;
        this.nombre = nombre;
        this.tagline = tagline;
        this.alcohol = alcohol;
        this.url = url;
    }

    public Cerveza(String nombre, String tagline, String url, double alcohol) {
        this.nombre = nombre;
        this.tagline = tagline;
        this.alcohol = alcohol;
        this.url = url;
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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Cerveza: {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tagline='" + tagline + '\'' +
                ", alcohol=" + alcohol + '\'' +
                ", url=" + url + 
            '}';
    }

}
