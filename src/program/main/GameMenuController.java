package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameMenuController implements Initializable {
    private final ViewState viewState ;

    public GameMenuController(ViewState viewState) {
        this.viewState = viewState ;
    }
    @FXML
    protected void onNewGameButtonClick(ActionEvent event) throws IOException {
        viewState.showStoryIntroduction();
    }

    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
