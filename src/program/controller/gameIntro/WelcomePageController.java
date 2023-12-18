package controller.gameIntro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.gamIntro.WelcomePage;
import view.ViewState;
import java.io.IOException;

public class WelcomePageController implements ChangeListener<Parent> {
    private final ViewState viewState;
    private WelcomePage welcomePage;
    @FXML
    private TextField playerName;
    @FXML
    private Label invalidName;
    @FXML
    private Label welcomeText;

    public WelcomePageController(ViewState viewState) {
        this.viewState = viewState;
        this.viewState.currentViewProperty().addListener(this);
    }

    @FXML
    protected void onEnterName(KeyEvent keyEvent) {
        invalidName.setVisible(false);
        welcomeText.setVisible(false);
        if(keyEvent.getCode() == KeyCode.ENTER) {
            boolean validPlayer = welcomePage.getPlayerName(playerName.getText());
            if (validPlayer){
                welcomeText.setVisible(true);
                welcomeText.setText(welcomePage.getWelcomeMsg());
            } else {
                invalidName.setVisible(true);
                invalidName.setText(welcomePage.getInvalidNameError());
            }
        }
    }

    @FXML
    protected void onContinueButtonAction() throws IOException {
        viewState.showFirstRoomDark();
    }

    @FXML
    protected void onLeaveButtonAction() throws IOException {
        viewState.showGameMenu();
    }

    private void setup() {
        playerName.setText("");
        welcomeText.setText("");
        invalidName.setVisible(false);
        welcomeText.setVisible(false);
        viewState.setGameIntroSize(viewState.getStage());
        welcomePage = viewState.getWelcomePage();
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getWelcomeView()) {
            setup();
        }
    }
}