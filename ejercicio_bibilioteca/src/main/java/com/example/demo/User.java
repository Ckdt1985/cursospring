package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  private int carnetNumber;

  protected User() {}

  public User(String firstName, String lastName, int carnetNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.carnetNumber = carnetNumber;
  }

  @Override
  public String toString() {
    return String.format(
        "User[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
  public int getCarnetNumber() {
    return carnetNumber;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String LastName) {
    this.lastName = LastName;
  }
  public void setCarnetNumber(int carnetNumber) {
    this.carnetNumber = carnetNumber;
  }
}
