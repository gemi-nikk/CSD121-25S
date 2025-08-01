package lab6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class Main extends Application {
    private final ObservableList<Song> playlist = FXCollections.observableArrayList();
    private final ListView<Song> playlistView = new ListView<>(playlist);
    @Override
    public void start(Stage primaryStage) {
        TextField titleField = new TextField();
        titleField.setPromptText("Song Title");
        TextField artistField = new TextField();
        artistField.setPromptText("Artist");
        Button addButton = new Button("Add to Playlist");
        Button clearButton = new Button("Clear Playlist");
        HBox inputBox = new HBox(10, titleField, artistField);
        HBox buttonBox = new HBox(10, addButton, clearButton);
        VBox root = new VBox(15, inputBox, buttonBox, playlistView);
        addButton.setOnAction(e -> {
            String title = titleField.getText().trim();
            String artist = artistField.getText().trim();
            if (!title.isEmpty() && !artist.isEmpty()) {
                playlist.add(new Song(title, artist));
                titleField.clear();
                artistField.clear();
            } else {
                showAlert("Please enter both title and artist.");
            }
        });
        clearButton.setOnAction(e -> playlist.clear());
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Playlist Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
