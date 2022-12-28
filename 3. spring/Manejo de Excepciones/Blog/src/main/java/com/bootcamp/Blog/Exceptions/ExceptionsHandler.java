package com.bootcamp.Blog.Exceptions;

import com.bootcamp.Blog.Controllers.BlogController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = BlogController.class)
public class ExceptionsHandler{

    @ExceptionHandler(BlogException.class)
    public 

}
