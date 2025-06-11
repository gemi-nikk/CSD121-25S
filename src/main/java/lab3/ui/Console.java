package lab3.ui;
import lab3.game.Board.Position;
import java.util.Scanner;
// handles user input from the console.
public class Console {
    private final Scanner scanner = new Scanner(System.in);
    //Asks the user for a position until it's valid.
    public Position getValidPosition() {
        while (true) {
            System.out.print("Enter row and column (e.g., '1 3' or 'm r'): ");
            String input = scanner.nextLine();
            try {
                return Position.parse(input); // Try to convert input to a position
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
