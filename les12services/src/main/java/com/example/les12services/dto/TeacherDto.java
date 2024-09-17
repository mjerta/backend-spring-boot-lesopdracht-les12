package com.example.les12services.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TeacherDto {
  public Long id;

  @NotBlank(message = "test")
  public String firstName;
  @Size(min = 3, max = 255)
  public String lastName;
  @Past
  public LocalDate dob;
  @Max(value = 1000, message = "too long mister")
  private int Salary;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public @NotBlank String getFirstName() {
    return firstName;
  }

  public void setFirstName(@NotBlank String firstName) {
    this.firstName = firstName;
  }

  public @Size(min = 3, max = 255) String getLastName() {
    return lastName;
  }

  public void setLastName(@Size(min = 3, max = 255) String lastName) {
    this.lastName = lastName;
  }

  public @Past LocalDate getDob() {
    return dob;
  }

  public void setDob(@Past LocalDate dob) {
    this.dob = dob;
  }

  @Max(value = 1000, message = "too long mister")
  public int getSalary() {
    return Salary;
  }

  public void setSalary(@Max(value = 1000, message = "too long mister") int salary) {
    Salary = salary;
  }
}
