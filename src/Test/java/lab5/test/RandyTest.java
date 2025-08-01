package lab5.test;

import lab5.players.RandyPlayer;
import lab5.game.Board;
import lab5.game.Position;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RandyTest {

    @Test
    public void testRandyOnlyPicksEmptyCells() {
        // Board: X O X O X - - - -
        Board board = new Board("XOXOX    ");
        List<Position> empty = board.getEmptyCells();

        RandyPlayer randy = new RandyPlayer("Randy");

        for (int i = 0; i < 100; i++) {
            Position move = randy.pickNextMove(board);
            assertTrue(empty.contains(move), "Randy picked a non-empty cell: " + move);
        }
    }

    @Test
    public void testRandyPicksAllPositionsOverTime() {
        Board board = new Board("         "); // all empty
        RandyPlayer randy = new RandyPlayer("Randy");

        Set<Position> seen = new HashSet<>();

        for (int i = 0; i < 500; i++) {
            Position move = randy.pickNextMove(board);
            seen.add(move);
        }

        assertEquals(9, seen.size(), "Randy did not eventually pick all 9 positions");
    }
}
