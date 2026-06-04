package io.github.responsekit.spring.exception;

public class InvalidPageException extends RuntimeException {
    public InvalidPageException(String message) {
        super(message);
    }
}
