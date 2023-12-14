package main;

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

public class FirstRoomController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ViewState viewState;

    public FirstRoomController(ViewState viewState) {
        this.viewState = viewState;
    }

    @FXML
    protected void firstRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/first-room.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("The Haunted Mansion: Room 1");
        stage.setScene(scene);
        setStageSize(stage);
        stage.show();
    }

    private void setStageSize(Stage stage) {
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
