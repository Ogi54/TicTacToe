package at.technikum;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        char currentPlayer = 'X';

        while (!board.isBoardFull()) {

            System.out.println("Current player: " + currentPlayer);

            System.out.println("Enter row:");
            int row = scanner.nextInt();

            System.out.println("Enter column:");
            int col = scanner.nextInt();

            board.makeMove(row, col, currentPlayer);

            board.printBoard();

            if (board.checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            }
            else {
                currentPlayer = 'X';
            }
        }

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
