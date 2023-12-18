package controller.firstRoom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import model.firstRoom.FirstRoomDark;
import view.ViewState;
import java.io.IOException;
import java.util.Objects;

public class FirstRoomDarkController implements ChangeListener<Parent> {
    private final ViewState viewState;
    private FirstRoomDark firstRoomDark;
    private AudioClip mediaPlayer;
    private boolean lightHasBeenOn = false;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label firstRoomTextBox;
    @FXML
    private Button candle;
    @FXML
    private Button goBack;

    public FirstRoomDarkController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    private void displayRoom() {
        candle.setVisible(false);
        goBack.setVisible(false);

        if (lightHasBeenOn) {
            displayCandleBlownOut();
        } else {
            displayStory();
        }
    }

    private void displayStory() {
        scrollPane.setFitToHeight(false);
        firstRoomTextBox.setText(firstRoomDark.getStory());
    }

    private void displayCandleBlownOut() {
        firstRoomTextBox.setText(firstRoomDark.getBlowOutCandle());
    }

    @FXML
    protected void onGirlButtonClicked() throws IOException {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/sounds/girl-scream.mp3")).toExternalForm());
        mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(3);
        mediaPlayer.play();
        viewState.showFirstRoomGameOver();
    }

    @FXML
    protected void onCandleButtonClicked() throws  IOException {
        goBack.setVisible(true);
        candle.setVisible(true);

        firstRoomTextBox.setText(firstRoomDark.getGoNearCandle());
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onLightCandleButtonClicked() throws IOException {
        lightHasBeenOn = true;
        viewState.showFirstRoomLight();
    }

    @FXML
    protected void onBookshelfButtonClick() {
        goBack.setVisible(true);
        candle.setVisible(false);
        firstRoomTextBox.setText(firstRoomDark.getGoNearBookshelf());
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onPaintingButtonClick() {
        goBack.setVisible(true);
        candle.setVisible(false);
        firstRoomTextBox.setText(firstRoomDark.getGoNearPaintings());
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onStartMenuButtonClicked(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        viewState.showGameMenu();
    }

    @FXML
    protected void onGoBackButtonClicked() {
        displayRoom();
    }

    private void setup() {
        viewState.setRoomSize();
        firstRoomDark = viewState.getFirstRoomDark();
        displayRoom();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomDarkView()) {
            setup();
        }
    }
}
