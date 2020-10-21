package tictactoe;

public class CoordinateFullException extends Throwable {
    public CoordinateFullException(int i, int j) {
        super("Coordinate i="+i+",j="+j+" is not empty");
    }
}
