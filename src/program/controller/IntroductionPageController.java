package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.ViewState;

import java.io.IOException;
import java.util.Objects;

public class IntroductionPageController implements ChangeListener<Parent> {
    @FXML
    private Label gameStory;
    private Stage stage;
    private final ViewState viewState;
    private Timeline timeline;
    @FXML
    private Button clickToContinue;
    @FXML
    private Button skip;
    private String storyText;
    private AudioClip mediaPlayer;

    public IntroductionPageController(ViewState viewState) {
        this.viewState = viewState;

        this.viewState.currentViewProperty().addListener(this);
    }

    private final int[] count = {0};

    @FXML
    private void displayStory() {
        char[] story = getCharacters();

        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.09),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                Platform.runLater(() -> {
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
        storyText = """
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

        return storyText.toCharArray();
    }

    @FXML
    protected void onContinueButtonAction(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        viewState.showWelcomePage();
    }

    @FXML
    protected void onSkipButtonAction(ActionEvent event) throws IOException {
        timeline.stop();
        gameStory.setText(storyText);
        clickToContinue.setVisible(true);
        skip.setVisible(false);
    }

    private void beginNarrator() {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/sounds/Narrator.wav")).toExternalForm());
        mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(1);
        mediaPlayer.play();
    }

    private void setup() {
        viewState.setStageSize(viewState.getStage());

        count[0] = 0;
        gameStory.setText("");
        skip.setVisible(true);
        clickToContinue.setVisible(false);
        displayStory();
        beginNarrator();
        timeline.play();
        timeline.setOnFinished(event -> {
            clickToContinue.setVisible(true);
            skip.setVisible(false);
        });
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getStoryIntroView()) {
            setup();
        }
    }
}
