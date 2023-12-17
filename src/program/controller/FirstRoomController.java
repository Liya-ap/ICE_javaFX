package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewState;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstRoomController implements ChangeListener<Parent> {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ViewState viewState;

    public FirstRoomController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    @FXML
    protected void onGirlButtonClicked() throws IOException {

    }

    private void setup() {
        viewState.getStage().setMinWidth(800);
        viewState.getStage().setMaxWidth(800);
        viewState.getStage().setMinHeight(435);
        viewState.getStage().setMaxHeight(435);
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getFirstRoomView()) {
            setup();
        }
    }
}
