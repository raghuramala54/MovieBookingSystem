package com.raghu.mbs.exceptions;

public class InvalidMovieRequestBodyException extends Exception {
    public InvalidMovieRequestBodyException(String message){
        super(message);
    }
}
