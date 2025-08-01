package lab5.test;

import lab5.players.CircePlayer;
import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CirceTest {

    @Test
    public void testCircePicksCenterFirst() {
        Board board = new Board("         "); // all cells empty
        CircePlayer circe = new CircePlayer("Circe");
        Position move = circe.pickNextMove(board);
        assertEquals(new Position(Row.Middle, Col.Middle), move);
    }

    @Test
    public void testCirceSkipsCenterIfTaken() {
        Board board = new Board("    X    "); // center is taken
        CircePlayer circe = new CircePlayer("Circe");
        Position move = circe.pickNextMove(board);
        assertEquals(new Position(Row.Top, Col.Middle), move); // next in preference
    }

    @Test
    public void testCirceContinuesClockwise() {
        Board board = new Board("X X X X X    "); // many preferred positions taken
        CircePlayer circe = new CircePlayer("Circe");
        Position move = circe.pickNextMove(board);
        // Whatever next available in preference list is expected
        // You can hardcode that value if you know which ones are still free
    }
}
