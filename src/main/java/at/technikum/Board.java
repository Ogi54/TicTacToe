package at.technikumwien.slt;

public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (cells[x][y] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("-------------");
        for (int y = 0; y < 3; y++) {
            System.out.print("| ");
            for (int x = 0; x < 3; x++) {
                System.out.print(cells[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public char[][] getCells() {
        return cells;
    }
}
