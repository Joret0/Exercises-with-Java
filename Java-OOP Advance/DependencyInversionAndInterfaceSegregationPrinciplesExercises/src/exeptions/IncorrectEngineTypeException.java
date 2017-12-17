package exeptions;

public class IncorrectEngineTypeException  extends RuntimeException{
    public IncorrectEngineTypeException(String message) {
        super(message);
    }
}
