package at.technikum;

public class App {

    public static void main(String[] args) {

        Board board = new Board();

        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(0, 1, 'X');

        board.makeMove(0,2,'X');
        board.makeMove(5, 5, 'X');

        System.out.println(board.isBoardFull());

        System.out.println(board.checkWinner('X'));

        board.printBoard();
    }
}
