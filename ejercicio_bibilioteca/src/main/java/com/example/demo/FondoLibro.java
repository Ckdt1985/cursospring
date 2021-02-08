package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FondoLibro {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private long idLibro;
  private int estado;

  protected FondoLibro() {}

  public FondoLibro(long idLibro, int estado) {
    this.idLibro = idLibro;
    this.estado = estado;
  }

  @Override
  public String toString() {
    return String.format(
        "FondoLibro[id=%d, idLibro='%s', estado=%s']",
        id, idLibro, estado);
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

  public void setIdLibro(long idLibro) {
    this.idLibro = idLibro;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

}
