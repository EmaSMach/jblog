package com.informatorio.jblog.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


// definimos como respondemos cuando se lanza nuestro excepción UserNotFoundException
@ControllerAdvice
public class UserNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND) // 404
  String userNotFoundHandler(UserNotFoundException ex) {
    return ex.getMessage();
  }
}
