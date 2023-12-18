package controller.firstRoom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import model.firstRoom.Paintings;
import view.ViewState;

import java.io.IOException;

public class PaintingsController implements ChangeListener<Parent> {
    private final ViewState viewState;
    private Paintings paintings;
    @FXML
    private Label firstRoomTextBox;
    @FXML
    private Button candle;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ScrollPane scrollPaneNote;
    @FXML
    private ImageView stickyNoteBig;
    @FXML
    private ImageView stickyNoteSmall;
    @FXML
    private ImageView exitNoteImg;
    @FXML
    private Button note;
    @FXML
    private Label noteRiddle;
    @FXML
    private Button exitNote;
    @FXML
    private Button goBack;
    private boolean checkedNote = false;
    public PaintingsController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    private void displayPaintings() {
        goBack.setVisible(true);
        exitNoteImg.setVisible(false);
        scrollPaneNote.setVisible(false);
        note.setVisible(true);
        stickyNoteBig.setVisible(false);
        exitNote.setVisible(false);
        scrollPane.setVisible(true);
        stickyNoteSmall.setVisible(true);

        if (checkedNote) {
            noteOnPaintingChecked();
        } else {
            lookAtPaintings();
        }
    }

    @FXML
    protected void onNoteButtonClicked() {
        exitNoteImg.setVisible(true);
        scrollPaneNote.setVisible(true);
        scrollPane.setVisible(false);
        goBack.setVisible(false);
        note.setVisible(false);
        stickyNoteSmall.setVisible(false);
        stickyNoteBig.setVisible(true);
        exitNote.setVisible(true);

        noteRiddle.setText(paintings.getRiddle());
    }

    @FXML
    protected void onExitNoteButtonClicked() throws IOException {
        checkedNote = true;
        displayPaintings();
    }

    protected void lookAtPaintings() {
        scrollPane.setFitToHeight(false);
        firstRoomTextBox.setText(paintings.getLookingAtPaintings());
    }

    @FXML
    protected void noteOnPaintingChecked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText(paintings.getRiddleSolved());
    }
    @FXML
    protected void onGoBackButtonClicked() throws IOException {
        viewState.showFirstRoomLight();
    }

    private void setup() {
        paintings = viewState.getPaintings();
        displayPaintings();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomPaintingsView()) {
            setup();
        }
    }
}
