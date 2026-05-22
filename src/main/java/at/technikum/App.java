package at.technikum;

public class App {

    public static void main(String[] args) {

        Board board = new Board();
        char currenPlayer = 'X';

        board.makeMove(0, 0, currenPlayer);
        currenPlayer = 'O';
        board.makeMove(1, 1, currenPlayer);
        currenPlayer = 'X';
        board.makeMove(0, 1, currenPlayer);

        board.makeMove(0,2,'X');
        board.makeMove(5, 5, 'X');

        System.out.println(board.isBoardFull());

        if (board.checkWinner('X')) {
            System.out.println("Player X wins!");
        }

        else if (board.isBoardFull()) {
            System.out.println("Draw!");
        }

        board.printBoard();
    }
}
