package com.fengcastelo.project.Services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(Object id) {
      super("Resource Not Found for id: " + id);
  }
}
