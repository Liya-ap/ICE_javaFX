package controller.firstRoom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import model.firstRoom.Bookshelf;
import view.ViewState;
import java.io.IOException;

public class BookshelfController implements ChangeListener<Parent> {
    private final ViewState viewState;
    private Bookshelf bookshelf;
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
        firstRoomTextBox.setText(bookshelf.getLookingAtBooks());
    }

    @FXML
    protected void onWrongBookClicked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText(bookshelf.getWrongBookChosen());
    }

    @FXML
    protected void onCorrectBookClicked() {
        scrollPane.setFitToHeight(true);
        firstRoomTextBox.setText(bookshelf.getCorrectBookChosen());
    }

    @FXML
    protected void onGoBackButtonClicked() throws IOException {
        viewState.showFirstRoomLight();
    }

    private void setup() {
        bookshelf = viewState.getBookshelf();
        displayBooks();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomBookshelfView()) {
            setup();
        }
    }
}
