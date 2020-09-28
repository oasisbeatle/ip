package Exceptions;

import java.lang.Exception;

/**
 * Exception if Donald can't process the task
 */
public class DukeException extends Exception {

    private String message;

    public DukeException(String message){
        super(message);
        this.message = message;
    }

    /**
     * @return Exception message as string
     */
    @Override
    public String getMessage() {
        return message;
    }
}
