package org.example.notescollector.exception;

public class UserNotFoundException extends RuntimeException {
     public UserNotFoundException(String message) {

     }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
