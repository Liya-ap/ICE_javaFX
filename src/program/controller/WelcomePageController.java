package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import entity.Player;
import view.ViewState;

import java.io.IOException;

public class WelcomePageController implements ChangeListener<Parent> {
    @FXML
    private TextField playerName;
    @FXML
    private Label invalidName;
    @FXML
    private Label welcomeText;
    private ViewState viewState;

    public WelcomePageController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    @FXML
    protected void onEnterName(KeyEvent keyEvent) {
        invalidName.setVisible(false);
        welcomeText.setVisible(false);
        if(keyEvent.getCode() == KeyCode.ENTER) {
            String input = playerName.getText();
            if (!input.matches(".*\\d+.*")) {
                String firstLetter = input.substring(0, 1);
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

    private void setup() {
        playerName.setText("");
        welcomeText.setText("");
        invalidName.setVisible(false);
        welcomeText.setVisible(false);
        viewState.setStageSize(viewState.getStage());
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getWelcomeView()) {
            setup();
        }
    }
}