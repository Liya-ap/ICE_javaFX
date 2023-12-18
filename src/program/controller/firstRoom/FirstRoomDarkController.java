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
import view.ViewState;
import java.io.IOException;
import java.util.Objects;

public class FirstRoomDarkController implements ChangeListener<Parent> {
    private final ViewState viewState;
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

    @FXML
    protected void displayStory() {
        scrollPane.setFitToHeight(false);
        firstRoomTextBox.setText("""
                You wake in a dark room feeling dizzy. You can’t see much but you appear to be in an old house of some sorts.
                You’re not quite sure where you are but one thing’s for sure. It’s cold. Almost freezing.
                Suddenly you hear a voice coming from the room. It sounds like a little girl, crying.
                
                "So cold... it’s... so cold..."
                
                You get on your feet, and try to look around in the dark.
                The room is filled with old furniture and paintings.
                
                In the middle of the room is a table with what looks to be a standing candle on it and maybe something next to it.
                To your right, are some paintings on the wall but you can’t make out any details.
                In the corner of the room you see a large, tall rectangular object, a bookshelf maybe?
                At the opposite end of the room you see a… a human, a little girl? Or whatever it is. It’s crying.
                Beside the little girl you see a door. A way out maybe.
                """);
    }

    protected void displayCandleBlownOut() {
        firstRoomTextBox.setText("""
                You blew out the candle that illuminated the room..
                Weirdo.
                """);
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
        firstRoomTextBox.setText("""
                Coming to the table you see a small metal object next to the standing candle.
                A lighter.
                It’s looks old but still functional.""");
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
        firstRoomTextBox.setText("""
                You see a lot of books on the shelf but it’s too dark in the room to make out any of the titles.
                Maybe something in the room could help to illuminate the place.
                """);
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onPaintingButtonClick() {
        goBack.setVisible(true);
        candle.setVisible(false);
        firstRoomTextBox.setText("""
                You see the silhouette of 5 paintings on the wall.
                But it’s too dark to see what's on them.
                Maybe something in the room could help to illuminate the place.
                """);
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
        displayRoom();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomDarkView()) {
            setup();
        }
    }
}
