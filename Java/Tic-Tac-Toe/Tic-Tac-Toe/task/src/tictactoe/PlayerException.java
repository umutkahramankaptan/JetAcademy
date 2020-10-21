package tictactoe;

public class PlayerException extends Throwable {
    public PlayerException(char player) {
        super("Player "+player+" is not valid");
    }
}
