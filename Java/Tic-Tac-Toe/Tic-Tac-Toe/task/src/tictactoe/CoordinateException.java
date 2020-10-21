package tictactoe;

public class CoordinateException extends Throwable {
    public CoordinateException(int i, int j) {
        super("Coordinate i="+i+",j="+j+" is not valid");
    }
}
