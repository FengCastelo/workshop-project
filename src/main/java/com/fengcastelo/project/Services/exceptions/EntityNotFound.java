package com.fengcastelo.project.Services.exceptions;

public class EntityNotFound extends RuntimeException {
    public EntityNotFound(Long id) {
        super("Entity Not Found with id: " + id);
    }
}
