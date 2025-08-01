package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;

import java.util.List;

/**
 * Circe: Picks center if free, then clockwise starting from top-middle.
 */
public class CircePlayer extends Player {

    public CircePlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> empty = currentBoard.getEmptyCells();

        // Preferred positions: center, then clockwise
        Position[] preferences = new Position[]{
                new Position(Row.Middle, Col.Middle),   // center
                new Position(Row.Top, Col.Middle),      // top-middle
                new Position(Row.Top, Col.Right),       // top-right
                new Position(Row.Middle, Col.Right),    // middle-right
                new Position(Row.Bottom, Col.Right),    // bottom-right
                new Position(Row.Bottom, Col.Middle),   // bottom-middle
                new Position(Row.Bottom, Col.Left),     // bottom-left
                new Position(Row.Middle, Col.Left),     // middle-left
                new Position(Row.Top, Col.Left)         // top-left
        };

        for (Position pos : preferences) {
            if (empty.contains(pos)) {
                return pos;
            }
        }

        // Fallback
        return empty.get(0);
    }
}
