package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class WelcomePageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField playerName;
    @FXML
    private Label invalidName;
    @FXML
    private Label welcomeText;
    private ViewState viewState;

    public WelcomePageController(ViewState viewState) {
        this.viewState = viewState;
    }

    @FXML
    protected void onEnterName(KeyEvent keyEvent) {
        invalidName.setVisible(false);
        welcomeText.setVisible(false);
        if(keyEvent.getCode() == KeyCode.ENTER ) {
            String input = playerName.getText();
            if (!input.matches(".*\\d+.*")) {
                String firstLetter = input.substring(0,1);
                String name = firstLetter.toUpperCase() + input.substring(1).toLowerCase();
                Player player = new Player(name);
                welcomeText.setVisible(true);
                welcomeText.setText("Do you dare to continue " + player.playerName() + "?");
            } else {
                invalidName.setVisible(true);
                invalidName.setText("Name must only contain letters.");
            }
        }
    }

    @FXML
    protected void onContinueButtonAction(ActionEvent event) throws IOException {
        viewState.showFirstRoom();
    }

    @FXML
    protected void onLeaveButtonAction(ActionEvent event) throws IOException {
        viewState.showGameMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}