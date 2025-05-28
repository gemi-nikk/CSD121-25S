package lab2;

import javax.imageio.ImageIO; // Used to handle image input/output operations
import javax.swing.*;  //  Provides GUI elements like windows and labels
import java.awt.*; // Offers graphical tools such as colors and layout managers
import java.io.IOException;  // Handles exceptions that occur during input/output
import java.io.InputStream;   // Abstract base class for reading binary input
import java.net.URI;  //Represents a Uniform Resource Identifier
import java.net.http.HttpClient;  //  Sends HTTP requests
import java.net.http.HttpRequest; //represents HTTP request
import java.net.http.HttpResponse; // represents the HTTP response

public class AvatarGenerator {

    public static void main(String[] args) {    //  Defines a class responsible for generating and showing an avatar

        try {
            var avatarStream = AvatarGenerator.getRandomAvatarStream();    // Retrieve a stream of avatar image data from the API
            AvatarGenerator.showAvatar(avatarStream);   //   Display the avatar using a window created with Swing
        } catch (IOException | InterruptedException e) {  //  // Handles input/output or thread interruption errors
            e.printStackTrace();
        }

    }

    public static InputStream getRandomAvatarStream() throws IOException, InterruptedException {
        // Pick a random style
        String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };  //  // An array containing the available avatar style names
        var style = styles[(int)(Math.random() * styles.length)];

        // Generate a random seed
        var seed = (int)(Math.random() * 10000);

        // Create an HTTP request for a random avatar
        var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
        var request = HttpRequest.newBuilder(uri).build();

        // Send the request
        try (var client = HttpClient.newHttpClient()) {
            var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return response.body();
        }
    }
    // Displays the avatar image in a graphical window
    public static void showAvatar(InputStream imageStream) {
            JFrame frame = new JFrame("PNG Viewer");  //   Create the main application window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //  closes app when window is closed
            frame.setResizable(false);  //
            frame.setSize(200, 200);  // set dimensions for the window
            frame.getContentPane().setBackground(Color.BLACK);  //  set background

            try {
                // Load the PNG image
                Image image = ImageIO.read(imageStream);

                // Create a JLabel to display the image
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                frame.add(imageLabel, BorderLayout.CENTER);     // Add the image label to the center of the frame layout

            } catch (IOException e) {
                e.printStackTrace();   // If there's an error loading the image, print the details
            }

            frame.setVisible(true);  // make a wimdow visible and calls an instance method to display the frame
    }
}
