package at.technikum;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        boolean playAgain = true;
        boolean gameOver = false;


        while (playAgain) {

            gameOver = false;
        Board board = new Board();

            char currentPlayer = 'X';

            while (!board.isBoardFull() && !gameOver) {

                System.out.println("Current player: " + currentPlayer);

                System.out.println("Enter row:");
                int row = scanner.nextInt();

                System.out.println("Enter column:");
                int col = scanner.nextInt();

                board.makeMove(row, col, currentPlayer);


                board.printBoard();


                if (board.checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                    break;
                }
                if (board.isBoardFull()) {
                    System.out.println("Draw!");
                    break;
                }
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }

                System.out.println("Play again? (y/n)");
                String answer = scanner.next();

                if (!answer.equalsIgnoreCase("y")) {
                    playAgain = false;
                }

            }


        }
    }
}
