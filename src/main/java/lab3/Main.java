package lab3;
import lab3.game.Board;
import lab3.game.Board.Player;
import lab3.game.Board.Position;
import lab3.ui.Console;
// This is the main class that runs the TicTacToe game.
public class Main {
    public static void main(String[] args) {
        Board board = new Board(); // Create empty game board
        Console console = new Console(); // Handle user input
        Player currentPlayer = Player.X; // Start with player X
        // Game loop
        while (true) {
            System.out.println(board); // Show the board
            // Check for win or draw
            if (board.checkWin(Player.X)) {
                System.out.println("Player X wins!");
                break;
            } else if (board.checkWin(Player.O)) {
                System.out.println("Player O wins!");
                break;
            } else if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }
            System.out.println("Player " + currentPlayer + ", enter your move:");
            Position pos = console.getValidPosition();
            // Prevent overwriting a spot
            if (board.isTaken(pos)) {
                System.out.println("That position is already taken. Try again.");
                continue;
            }
            board.place(currentPlayer, pos); // Place player's symbol
            // Switch player
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
        }
    }
}
