package com.pedrioko.github.cmsapi.exceptions;

public class TagNotFoundException extends RuntimeException {

    public TagNotFoundException(Long id) {
        super("Could not find tag " + id);
    }
}
