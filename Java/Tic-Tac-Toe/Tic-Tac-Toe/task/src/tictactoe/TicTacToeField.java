package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToeField {
    StringBuilder table;
    Scanner scanner;
    char firstPlayer='X';

    public TicTacToeField() {
        this.table=new StringBuilder("_________");
        scanner = new Scanner(System.in);
    }
/*
    public TicTacToeField(java.io.InputStream iStream) throws InitializationException {
        scanner = new Scanner(iStream);

        String initial = scanner.nextLine();
        if (initial.length()!=9) {
            this.table=new StringBuilder("_________");
            throw new InitializationException(initial);
        }

        for (int i=0; i<9; i++){
            char loc = initial.charAt(i);
            if (loc != 'X' && loc != 'O'  && loc != '_') {
                this.table=new StringBuilder("_________");
                throw new InitializationException(initial);
            }
            table= new StringBuilder(initial);
        }
    }
*/
    /* public void printTable(){
        printField();
        printOutcome();
    }*/

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < 3 ; i++) {
            System.out.print('|');
            System.out.print(' ');
            for (int j = 0; j < 3; j++) {
                System.out.print(this.table.charAt(j+3*i));
                System.out.print(' ');
            }
            System.out.println('|');
        }
        System.out.println("---------");
    }

    public int numberOfTurns(char player){
        int turns=0;
        for (int i = 0; i < 9 ; i++) {
            if (table.charAt(i) == player) {
                turns++;
            }
        }
        return turns;
    }

    public boolean doesPlayerWins(char player) {
        if (
                (table.charAt(0)==player && table.charAt(1)==player && table.charAt(2)==player) ||
                (table.charAt(3)==player && table.charAt(4)==player && table.charAt(5)==player) ||
                (table.charAt(6)==player && table.charAt(7)==player && table.charAt(8)==player) ||
                (table.charAt(0)==player && table.charAt(3)==player && table.charAt(6)==player) ||
                (table.charAt(1)==player && table.charAt(4)==player && table.charAt(7)==player) ||
                (table.charAt(2)==player && table.charAt(5)==player && table.charAt(8)==player) ||
                (table.charAt(0)==player && table.charAt(4)==player && table.charAt(8)==player) ||
                (table.charAt(2)==player && table.charAt(4)==player && table.charAt(6)==player)
        ) return true;
        return false;
    }

    public boolean isPlayable(){
        for (int i = 0; i < 9 ; i++) {
            if (table.charAt(i) == '_') {
                return true;
            }
        }
        return false;
    }

    public void playGame(){
        printField();
        char player = firstPlayer;
        boolean moveSuccessful;
        while (isPlayable()&&!isImpossible()&&!doesPlayerWins('X')&&!doesPlayerWins('O')){
            moveSuccessful = requestMove(player);
            if (moveSuccessful) {
                player = player == 'X' ? 'O' : 'X';
            }
            printField();
        }
        printOutcome();

    }


    public boolean requestMove(char player){
        //if (!isPlayable()) return false;
        System.out.print("Enter the coordinates: ");
        int i, j;
        try {
            i = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return false;
        }
        try {
            j = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return false;
        }

        try {
            setCoordinate(i, j, player);
            return true;
        } catch (CoordinateException e) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } catch (PlayerException e) {
            e.printStackTrace();
            return false;
        } catch (CoordinateFullException e) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public boolean isImpossible(){
        return  (Math.abs(numberOfTurns('X') - numberOfTurns('O')) > 1 ) ||
                (doesPlayerWins('X') && doesPlayerWins('O'));
    }


    public void printOutcome(){
        boolean x_wins = doesPlayerWins('X');
        boolean o_wins = doesPlayerWins('O');
        boolean playable = isPlayable();

        if (isImpossible()) {
            System.out.println("Impossible");
            return;
        }

        if (!x_wins && !o_wins && !playable) {
            System.out.println("Draw");
            return;
        }

        if (x_wins && o_wins) {
            System.out.println("Impossible");
            return;
        }

        if (x_wins) {
            System.out.println("X wins");
            return;
        }

        if (o_wins) {
            System.out.println("O wins");
            return;
        }

        //playable
        System.out.println("Game not finished");
    }

    public void setCoordinate(int i, int j, char player) throws CoordinateException, PlayerException, CoordinateFullException {
        if ((i<1 || i>3) || (j<1 || j>3)) {
            throw new CoordinateException(i,j);
        }

        if (player != 'X' && player != 'O') {
            throw new PlayerException(player);
        }

        if (this.table.charAt((i-1)+3*(3-j))!='_') {
            throw new CoordinateFullException(i,j);
        }

        this.table.setCharAt((i-1)+3*(3-j),player);
    }
}
