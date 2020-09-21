package com.pedrioko.github.cmsapi.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id) {
        super("Could not find category " + id);
    }
}
