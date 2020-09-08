import java.lang.Exception;

public class DukeException extends Exception {

    public String message;

    public DukeException(String message){
        super(message);
        this.message = message;
    }

}
