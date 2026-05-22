package at.technikumwien.slt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void isCellEmptyPositive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmptyNegative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void placePositive() {
        board.place(0, 0, 'X');
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    void placeNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.place(3, 0, 'X'));
    }

    @Test
    void isFullPositive() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isFullNegative() {
        assertFalse(board.isFull());
    }

    @Test
    void clearPositive() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void clearNegative() {
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCells()[i][j]);
            }
        }
    }

    @Test
    void printPositive() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        board.print();
        String expected = "-------------" + System.lineSeparator() +
                "|   |   |   | " + System.lineSeparator() +
                "|   |   |   | " + System.lineSeparator() +
                "|   |   |   | " + System.lineSeparator() +
                "-------------" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void printNegative() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.print();
        String expected = "-------------" + System.lineSeparator() +
                "| X | X | X | " + System.lineSeparator() +
                "| X | X | X | " + System.lineSeparator() +
                "| X | X | X | " + System.lineSeparator() +
                "-------------" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void getCellsPositive() {
        char[][] expected = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        assertArrayEquals(expected, board.getCells());
    }

    @Test
    void getCellsNegative() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        char[][] expected = {
                { 'X', 'X', 'X' },
                { 'X', 'X', 'X' },
                { 'X', 'X', 'X' }
        };
        assertArrayEquals(expected, board.getCells());
    }
}
