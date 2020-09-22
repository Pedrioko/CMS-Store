package com.pedrioko.github.cmsapi.controllersadvices;

import com.pedrioko.github.cmsapi.exceptions.TagNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TagNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TagNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoryNotFoundHandler(TagNotFoundException ex) {
        return ex.getMessage();
    }
}
