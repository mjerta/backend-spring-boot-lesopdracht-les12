package com.example.les12services.exception;

public class DuplicateNamesFound extends RuntimeException {
  public DuplicateNamesFound(String message) {
    super(message);
  }
}
