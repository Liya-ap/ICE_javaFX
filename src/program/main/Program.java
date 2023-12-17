package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import view.ViewState;

import java.io.IOException;
import java.util.Objects;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/sounds/Horror-Long-Version.mp3")).toExternalForm());
        AudioClip mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();

        ViewState viewState = new ViewState();
        viewState.setStage(stage);
        viewState.showGameMenu();
        Scene scene = new Scene(viewState.currentViewProperty().get());
        scene.rootProperty().bind(viewState.currentViewProperty());
        viewState.setStageTitle("Escape Room: The Haunted House");
        stage.setScene(scene);
        stage.show();
    }
}
