package com.raghu.mbs.exceptionhandler;

import com.raghu.mbs.exceptions.InvalidMovieRequestBodyException;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.exceptions.StatusDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {
    /**
     * use of the controllerAdvice annotation, enables this class to intercept any kind of exception.
     */
    /**
     * Need to handle MovieDetails NotFoundException
     */
    @ExceptionHandler(MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieDetailsNotFoundException(){
        return new ResponseEntity("Movie id passed is not correct", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidMovieRequestBodyException.class)
    public ResponseEntity handleBadMovieDetailsNotFoundException(){
        return new ResponseEntity("Request passed is having problems", HttpStatus.BAD_REQUEST);
    }
}
