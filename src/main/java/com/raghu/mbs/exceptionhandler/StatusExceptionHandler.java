package com.raghu.mbs.exceptionhandler;

import com.raghu.mbs.exceptions.StatusDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StatusExceptionHandler {

    @ExceptionHandler(StatusDetailsNotFoundException.class)
    public ResponseEntity handleStatusDetailsNotFoundException(){
        return new ResponseEntity("status passed is not correct", HttpStatus.BAD_REQUEST);
    }
}
