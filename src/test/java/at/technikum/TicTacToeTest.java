package at.technikumwien.slt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void getInputPositive() {
        String simulatedInput = "0\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        assertEquals(0, ticTacToe.getInput(""));
        System.setIn(System.in);
    }

    @Test
    void getInputNegative() {
        String simulatedInput = "3\n-1\n2\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        assertEquals(2, ticTacToe.getInput(""));
        System.setIn(System.in);
    }

    @Test
    void switchCurrentPlayerPositive() {
        Player currentPlayer = ticTacToe.currentPlayer;
        ticTacToe.switchCurrentPlayer();
        assertNotEquals(currentPlayer, ticTacToe.currentPlayer);
    }

    @Test
    void switchCurrentPlayerNegative() {
        Player originalPlayer = ticTacToe.currentPlayer;
        ticTacToe.switchCurrentPlayer();
        ticTacToe.switchCurrentPlayer();
        assertEquals(originalPlayer, ticTacToe.currentPlayer);
    }

    @Test
    void hasWinnerPositive() {
        ticTacToe.board.place(0, 0, 'X');
        ticTacToe.board.place(0, 1, 'X');
        ticTacToe.board.place(0, 2, 'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinnerNegative() {
        assertFalse(ticTacToe.hasWinner());
    }
}
