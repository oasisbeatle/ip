package Exceptions;

import java.lang.Exception;

public class DukeException extends Exception {

    private String message;

    public DukeException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
