package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private long idLibro;
  private long idUsuario;
  private long idFondo;
  private String fechaPrestamo;
  private String fechaDevolucion;

  protected Transaction() {}

  public Transaction(long idLibro, long idUsuario, long idFondo, String fechaPrestamo, String fechaDevolucion) {
    this.idLibro = idLibro;
    this.idUsuario = idUsuario;
    this.idFondo = idFondo;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaDevolucion = fechaDevolucion;
  }

  @Override
  public String toString() {
    return String.format(
        "Transaction[id=%d, idLibro='%s', idUsuario='%s, idFondo='%s', FechaPrestamo='%s', FechaDevolucion='%s']",
        id, idLibro, idUsuario, idFondo, fechaPrestamo, fechaDevolucion);
  }

  public String getFechaPrestamo(){
    return this.fechaPrestamo;
  }

  public void setfechaPrestamo( String fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public String getFechaDevolucion(){
    return this.fechaDevolucion;
  }

  public void setFechaDevolucion( String fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getIdLibro() {
    return idLibro;
  }

  public long getIdUsuario() {
    return idUsuario;
  }

  public long getIdFondo() {
    return idFondo;
  }

  public void setIdLibro(long idLibro) {
    this.idLibro = idLibro;
  }

  public void setIdUsuario(long idUsuario) {
    this.idUsuario = idUsuario;
  }

  public void setIdFondo(long idFondo) {
    this.idFondo = idFondo;
  }

}
