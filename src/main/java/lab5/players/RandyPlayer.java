package lab5.players;

import lab5.game.Board;
import lab5.game.Position;

import java.util.List;
import java.util.Random;

/**
 * Randy: picks a random empty cell every time.
 */
public class RandyPlayer extends Player {

    private final Random random = new Random();

    public RandyPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> empty = currentBoard.getEmptyCells();
        return empty.get(random.nextInt(empty.size()));
    }
}
