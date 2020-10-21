package tictactoe;

public class InitializationException extends Throwable {
    public InitializationException(String initial) {
        super("String "+initial+ " is not a valid initialization value");
    }
}
