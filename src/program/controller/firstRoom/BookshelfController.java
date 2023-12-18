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

public class BookshelfController implements ChangeListener<Parent> {
    private final ViewState viewState;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label firstRoomTextBox;
    @FXML
    private Button goBack;

    public BookshelfController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    private void displayBooks() {
        goBack.setVisible(true);
        lookAtBooks();
    }

    private void lookAtBooks() {
        scrollPane.setFitToHeight(false);
        firstRoomTextBox.setText("""
                 On the large bookshelf you see a lot of different titles: “IT, Saw, American Psycho, Sinister”.
                 At the top of the shelf is a sign, “Horror”.
                 You quickly realize that all the books are old and new Horror titles and you ask yourself “Why”?
                 Some of the books are very old, others more recent.
                """);
    }

    @FXML
    protected void onWrongBookClicked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText("""
                You flip through the pages and nothing is out of the ordinary..
                """);
    }

    @FXML
    protected void onCorrectBookClicked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText("""
                You flip through the pages and notice a strange message.
                You say the word out loud, and you're suddenly startled with a loud noise!
                The bookshelf begins to move.
                After a short while, a keypad behind the bookshelf has been revealed.
                 """);
    }

    @FXML
    protected void onGoBackButtonClicked() throws IOException {
        viewState.showFirstRoomLight();
    }

    private void setup() {
        displayBooks();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomBookshelf()) {
            setup();
        }
    }
}
