package controller.firstRoom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import view.ViewState;

import java.io.IOException;

public class FirstRoomLightController implements ChangeListener<Parent> {
    private final ViewState viewState;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label firstRoomTextBox;
    @FXML
    private Button candle;
    @FXML
    private Button goBack;
    public FirstRoomLightController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    private void displayRoom() {
        goBack.setVisible(false);
        candle.setVisible(false);

        firstRoomTextBox.setText("""
                The room is now lit up and you can see everything more clearly.
                """);
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onGirlButtonClicked() throws IOException {
        System.out.println("Not done..");
    }

    @FXML
    protected void onCandleButtonClicked() throws  IOException {
        goBack.setVisible(true);
        candle.setVisible(true);

        firstRoomTextBox.setText("""
                The candle is currently illuminating the room.
                """);
        scrollPane.setFitToHeight(true);
    }

    @FXML
    protected void onBlowOutCandleButtonClicked() throws IOException {
        viewState.showFirstRoomDark();
    }

    @FXML
    protected void onBookshelfButtonClick() throws IOException {
        viewState.showFirstRoomBookshelf();
    }

    @FXML
    protected void onPaintingButtonClick() throws IOException {
        viewState.showFirstRoomPaintings();
    }

    @FXML
    protected void onGoBackButtonClicked() throws IOException {
        displayRoom();
    }

    private void setup() {
        viewState.setRoomSize();
        displayRoom();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomLightView()) {
            setup();
        }
    }
}
