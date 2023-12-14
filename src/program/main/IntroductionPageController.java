package main;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class IntroductionPageController implements Initializable {
    @FXML
    private Label gameStory;
    private Stage stage;
    private ViewState viewState;
    private Timeline timeline;
    @FXML
    private Button clickToContinue;
    @FXML
    private Button skip;
    private String story;
    private AudioClip mediaPlayer;

    public IntroductionPageController(ViewState viewState) {
        this.viewState = viewState;
    }

     @FXML
    private void displayStory() {
        char[] story = getCharacters();
        final int[] count = {0};

        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.09),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent actionEvent) {
                                Platform.runLater(()->{
                                    gameStory.setText(gameStory.getText() + story[count[0]]);
                                    count[0]++;
                                });
                            }
                        }
                )
        );
        timeline.setCycleCount(story.length);
    }

    private char[] getCharacters() {
        story = """
                Welcome, brave soul, to "The Haunted Mansion" – an escape room like no other.\s
                I’m the GameMaster and I will try to help you where I can. \s
                But I don’t have all the answers.\s
                There are some things you have to figure out on your own. \s
                You will be tested in different puzzles and obstacles. \s
                Objects and items will come up along the way. \s
                Remember them. \s
                They’re important. \s
                But don’t take too long. \s
                Time is of the essence, someone or something may be watching you, waiting...""";

        return story.toCharArray();
    }

    @FXML
    protected void onContinueButtonAction(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        viewState.showWelcomePage();
    }

    @FXML
    protected void onSkipButtonAction(ActionEvent event) throws IOException {
        timeline.stop();
        gameStory.setText(story);
        clickToContinue.setVisible(true);
        skip.setVisible(false);
    }

    private void beginNarrator() {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/sounds/Narrator.wav")).toExternalForm());
        mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clickToContinue.setVisible(false);
        displayStory();
        beginNarrator();
        timeline.play();
        timeline.setOnFinished(event -> {
            clickToContinue.setVisible(true);
            skip.setVisible(false);
        });
    }
}
