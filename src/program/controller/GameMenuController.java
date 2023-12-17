package controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import view.ViewState;

import java.io.IOException;

public class GameMenuController implements ChangeListener<Parent> {
    private final ViewState viewState ;

    public GameMenuController(ViewState viewState) {
        this.viewState = viewState ;
        this.viewState.currentViewProperty().addListener(this);
    }
    @FXML
    protected void onNewGameButtonClick(ActionEvent event) throws IOException {
        viewState.showStoryIntroduction();
    }

    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    private void setup() {
        viewState.setStageSize(viewState.getStage());
    }

    @Override
    public void changed(ObservableValue<? extends Parent> observableValue, Parent oldParent, Parent newParent) {
        if (newParent == viewState.getGameMenuView()) {
            setup();
        }
    }
}
