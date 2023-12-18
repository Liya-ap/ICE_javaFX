package controller.firstRoom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import view.ViewState;

import java.io.IOException;

public class PaintingsController implements ChangeListener<Parent> {
    private final ViewState viewState;
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

        noteRiddle.setText("""
                What is the highest number between 1 and 1.000.000 that does not contain the letter “N” when said out loud?
                
                Take that number and subtract 19 from it.
                Remember the result.
                
                Now take the number and add 351 to it.
                Remember the result.
                
                You should now have a two-digit number and a three-digit number.
                Put them together in the order you got them to make a five-digit number.
                
                Remember this final number. You'll need it.""");
    }

    @FXML
    protected void onExitNoteButtonClicked() throws IOException {
        checkedNote = true;
        displayPaintings();
    }

    protected void lookAtPaintings() {
        scrollPane.setFitToHeight(false);
        firstRoomTextBox.setText("""
                 You take a look at the 5 paintings on the wall.
                 All of them depict something different.
                 Different people, doing different things.
                 They do have one thing in common though. They're all smiling.
                 No matter what they're doing or what's happening in the painting,
                 the people are smiling.
                 
                 In the middle of the biggest painting, you see a note..
                """);
    }

    @FXML
    protected void noteOnPaintingChecked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText("""
                 With that done you’ve now acquired a five-digit number.
                 It looks like that's about all you can do with the paintings.
                 Maybe these clues you've gathered can be used somewhere else?
                """);
    }
    @FXML
    protected void onGoBackButtonClicked() throws IOException {
        viewState.showFirstRoomLight();
    }

    private void setup() {
        displayPaintings();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomPaintings()) {
            setup();
        }
    }
}
