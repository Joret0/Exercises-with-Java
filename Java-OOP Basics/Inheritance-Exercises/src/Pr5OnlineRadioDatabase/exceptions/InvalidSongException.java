package Pr5OnlineRadioDatabase.exceptions;

public class InvalidSongException extends NumberFormatException{

    public InvalidSongException() {
        super("Invalid song.");
    }

    public InvalidSongException(String message) {
        super(message);
    }
}
