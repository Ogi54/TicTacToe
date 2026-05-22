package at.technikumwien.slt;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    protected Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        boolean playing = true;
        while (playing) {
            System.out.println("Current player: " + currentPlayer.getMarker());
            board.print();
            int row = getInput("row (0-2): ");
            int col = getInput("column (0-2): ");
            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " has won!");
                    playing = false;
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("Stalemate!");
                    playing = false;
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("Position is occupied, please try again.");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Up for another game? (Y/N)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("Y")) {
            board.clear();
            start();
        }
    }

    protected int getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.print(message);
            input = scanner.nextInt();
        } while (input < 0 || input > 2);
        return input;
    }

    protected void switchCurrentPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    protected boolean hasWinner() {
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            if ((cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) ||
                    (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i])) {
                return true;
            }
        }
        return (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) ||
                (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]);
    }
}
