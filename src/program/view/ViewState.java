package view;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.FirstRoomController;
import controller.GameMenuController;
import controller.IntroductionPageController;
import controller.WelcomePageController;

import java.io.IOException;
import java.util.Objects;

public class ViewState {

    private final ReadOnlyObjectWrapper<Parent> currentView = new ReadOnlyObjectWrapper<>();
    private Parent gameMenuView;
    private Parent storyIntroView;
    private Parent welcomeView;
    private Parent firstRoomView;
    private Stage stage;
    private Scene scene;

    public ReadOnlyObjectProperty<Parent> currentViewProperty() {
        return currentView.getReadOnlyProperty();
    }

    public void showGameMenu() throws IOException {
        if (gameMenuView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/game-menu.fxml")));
            loader.setController(new GameMenuController(this));
            gameMenuView = loader.load();
            if (stage != null) {
                setStageTitle("Escape Room Game: The Haunted Mansion");
            }
        }
        currentView.set(gameMenuView);
    }

    public void showStoryIntroduction() throws IOException {
        if (storyIntroView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/story-introduction-page.fxml")));
            IntroductionPageController introductionPageController = new IntroductionPageController(this);

            loader.setController(introductionPageController);
            storyIntroView = loader.load();
            setStageTitle("The Haunted Mansion: The Story");
        }
        currentView.set(storyIntroView);

    }

    public void showWelcomePage() throws IOException {
        if (welcomeView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/welcome-page.fxml")));
            loader.setController(new WelcomePageController(this));
            welcomeView = loader.load();
            setStageTitle("The Haunted Mansion: Brave Soul, Who are you?");
        }
        currentView.set(welcomeView);
    }

    public void showFirstRoom() throws IOException {
        if (firstRoomView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/first-room.fxml")));
            loader.setController(new FirstRoomController(this));
            firstRoomView = loader.load();
            setStageTitle("The Haunted Mansion: Room One");
        }
        currentView.set(firstRoomView);
    }


    public Parent getGameMenuView() {
        return gameMenuView;
    }

    public Parent getStoryIntroView() {
        return storyIntroView;
    }

    public Parent getWelcomeView() {
        return welcomeView;
    }

    public Parent getFirstRoomView() {
        return firstRoomView;
    }

    public void setStageSize(Stage stage) {
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStageTitle(String title) {
        stage.setTitle(title);
    }
}