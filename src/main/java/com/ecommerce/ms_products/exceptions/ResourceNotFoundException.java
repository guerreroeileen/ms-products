package com.ecommerce.ms_products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class ResourceNotFoundException extends ResponseStatusException {
    public ResourceNotFoundException(String entityName, UUID ID) {
        super(HttpStatus.NOT_FOUND, String.format("Not results found for {} with id: {}"));
    }
}
