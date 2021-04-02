package com.fullstack.laucher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDexception extends RuntimeException{

  public ProjectIDexception(String message) {
    super(message);
  }
  
}
