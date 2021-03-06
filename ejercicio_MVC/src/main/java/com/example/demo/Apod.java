package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apod {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String descripcion;

    private String fecha;
    private String url;

    // avoid this "No default constructor for entity"
    public Apod() {
    }

    public Apod(Long id, String titulo, String descripcion, String fecha, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.url = url;
    }

    public Apod(String titulo, String descripcion, String fecha, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Apod{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha + '\'' +
                ", url=" + url + 
            '}';
    }

}
