package controller.gameIntro;

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
import model.gamIntro.IntroductionPage;
import view.ViewState;

import java.io.IOException;
import java.util.Objects;

public class IntroductionPageController implements ChangeListener<Parent> {
    private final ViewState viewState;
    private IntroductionPage introductionPage;
    private Timeline timeline;
    private AudioClip mediaPlayer;
    private final int[] count = {0};
    @FXML
    private Label gameStory;
    @FXML
    private Button clickToContinue;
    @FXML
    private Button skip;

    public IntroductionPageController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    private void displayStory() {
        char[] story = introductionPage.getCharacters();

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

    private void beginNarrator() {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/sounds/Narrator.wav")).toExternalForm());
        mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(1);
        mediaPlayer.play();
    }

    @FXML
    protected void onContinueButtonAction() throws IOException {
        mediaPlayer.stop();
        viewState.showWelcomePage();
    }

    @FXML
    protected void onSkipButtonAction() throws IOException {
        timeline.stop();
        gameStory.setText(introductionPage.getStory());
        clickToContinue.setVisible(true);
        skip.setVisible(false);
    }

    private void setup() {
        viewState.setGameIntroSize(viewState.getStage());
        introductionPage = viewState.getIntroductionPage();

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
