package lab3.game;
//This class holds the TicTacToe board and game logic.
public class Board {
    private final Player[][] grid;
    public Board() {
        grid = new Player[3][3]; // Empty 3x3 board
    }
    public boolean isTaken(Position pos) {
        return grid[pos.getRow().ordinal()][pos.getCol().ordinal()] != null;
    }
    public void place(Player player, Position pos) {
        grid[pos.getRow().ordinal()][pos.getCol().ordinal()] = player;
    }
    public boolean checkWin(Player player) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) ||
                    (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        return (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
                (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);
    }
    public boolean isDraw() {
        for (Player[] row : grid) {
            for (Player cell : row) {
                if (cell == null) return false; // Found empty cell
            }
        }
        return true; // All cells filled and no winner
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n  1 2 3\n");
        Row[] rows = Row.values();
        for (int i = 0; i < 3; i++) {
            sb.append(rows[i].symbol()).append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(grid[i][j] == null ? "." : grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    // Inner Type Enums
    public enum Player {
        X, O
    }
    public enum Row {
        TOP("t"), MIDDLE("m"), BOTTOM("b");
        private final String symbol;
        Row(String symbol) { this.symbol = symbol; }
        public String symbol() { return symbol; }

        public static Row parse(String input) {
            switch (input.toLowerCase()) {
                case "1", "t": return TOP;
                case "2", "m", "c": return MIDDLE;
                case "3", "b": return BOTTOM;
                default: throw new IllegalArgumentException("Invalid row input.");
            }
        }
    }
    public enum Column {
        LEFT("l"), MIDDLE("m"), RIGHT("r");
        private final String symbol;
        Column(String symbol) { this.symbol = symbol; }
        public String symbol() { return symbol; }

        public static Column parse(String input) {
            switch (input.toLowerCase()) {
                case "1", "l":
                    return LEFT;
                case "2", "m", "c":
                    return MIDDLE;
                case "3", "r":
                    return RIGHT;
                default:
                    throw new IllegalArgumentException("Invalid column input.");
            }
        }
    }
    // This class represents a position on the board - row and colounm
    public static class Position {
        private final Row row;
        private final Column col;
        public Position(Row row, Column col) {
            this.row = row;
            this.col = col;
        }
        public Row getRow() { return row; }
        public Column getCol() { return col; }

        public static Position parse(String input) {
            String[] parts = input.trim().toLowerCase().split("\\s+");
            if (parts.length != 2) throw new IllegalArgumentException("Expected 2 values.");
            Row row = Row.parse(parts[0]);
            Column col = Column.parse(parts[1]);
            return new Position(row, col);
        }
    }
}
