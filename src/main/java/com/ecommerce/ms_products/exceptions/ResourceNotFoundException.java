package com.ecommerce.ms_products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static com.ecommerce.ms_products.constants.ErrorMessageConstants.NOT_RESULTS_FOUND_FOR_WITH_ID;

public class ResourceNotFoundException extends ResponseStatusException {
    public ResourceNotFoundException(String entityName, UUID ID) {
        super(HttpStatus.NOT_FOUND, String.format(NOT_RESULTS_FOUND_FOR_WITH_ID, entityName, ID));
    }
}
