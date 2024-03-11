package dev.gamedev.project.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends RuntimeException{

    public GameNotFoundException(String message) {
        super(message);
    }
}
