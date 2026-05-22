package at.technikum;

public class Board {

    private final char[][] board;

    public Board() {
        board = new char[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        board[row][col] = symbol;
        return true;
    }

    public boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkWinner(char symbol) {

        // Reihen prüfen
        for (int row = 0; row < 3; row++) {

            if (board[row][0] == symbol &&
                    board[row][1] == symbol &&
                    board[row][2] == symbol) {

                return true;
            }
        }

        // Spalten prüfen
        for (int col = 0; col < 3; col++) {

            if (board[0][col] == symbol &&
                    board[1][col] == symbol &&
                    board[2][col] == symbol) {

                return true;
            }
        }

        // Diagonale links oben -> rechts unten
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol) {

            return true;
        }

        // Diagonale rechts oben -> links unten
        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol) {

            return true;
        }

        return false;
    }


    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
