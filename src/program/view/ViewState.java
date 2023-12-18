package view;

import controller.firstRoom.BookshelfController;
import controller.firstRoom.FirstRoomDarkController;
import controller.firstRoom.FirstRoomLightController;
import controller.firstRoom.PaintingsController;
import controller.gameIntro.GameMenuController;
import controller.gameIntro.IntroductionPageController;
import controller.gameIntro.WelcomePageController;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewState {
    private final ReadOnlyObjectWrapper<Parent> currentView = new ReadOnlyObjectWrapper<>();
    private Parent gameMenuView;
    private Parent storyIntroView;
    private Parent welcomeView;
    private Parent firstRoomDarkView;
    private Parent firstRoomLightView;
    private Parent firstRoomGameOver;
    private Parent firstRoomPaintings;

    private Parent firstRoomBookshelf;

    private Stage stage;
    private Scene scene;
    private final GameMenuController gameMenuController = new GameMenuController(this);
    private final IntroductionPageController introductionPageController = new IntroductionPageController(this);
    private final WelcomePageController welcomePageController = new WelcomePageController(this);
    private final FirstRoomDarkController firstRoomDarkController = new FirstRoomDarkController(this);
    private final FirstRoomLightController firstRoomLightController = new FirstRoomLightController(this);
    private final PaintingsController paintingsController = new PaintingsController(this);
    private final BookshelfController bookshelfController = new BookshelfController(this);

    public ReadOnlyObjectProperty<Parent> currentViewProperty() {
        return currentView.getReadOnlyProperty();
    }
    public void showGameMenu() throws IOException {
        if (gameMenuView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/game-menu.fxml")));
            loader.setController(gameMenuController);
            gameMenuView = loader.load();
        }

        setStageTitle("Escape Room Game: The Haunted Mansion");
        currentView.set(gameMenuView);
    }

    public void showStoryIntroduction() throws IOException {
        if (storyIntroView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/story-introduction-page.fxml")));
            loader.setController(introductionPageController);
            storyIntroView = loader.load();
        }

        setStageTitle("The Haunted Mansion: The Story");
        currentView.set(storyIntroView);
    }

    public void showWelcomePage() throws IOException {
        if (welcomeView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/welcome-page.fxml")));
            loader.setController(welcomePageController);
            welcomeView = loader.load();
        }

        setStageTitle("The Haunted Mansion: Brave Soul, Who are you?");
        currentView.set(welcomeView);
    }

    public void showFirstRoomDark() throws IOException {
        if (firstRoomDarkView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-dark.fxml")));
            loader.setController(firstRoomDarkController);
            firstRoomDarkView = loader.load();
        }

        setStageTitle("The Haunted Mansion: Room One");
        currentView.set(firstRoomDarkView);
    }

    public  void showFirstRoomGameOver() throws IOException {
        if (firstRoomGameOver == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/game-over.fxml")));
            loader.setController(firstRoomDarkController);
            firstRoomGameOver = loader.load();
        }

        setStageTitle("You died..");
        currentView.set(firstRoomGameOver);
    }

    public void showFirstRoomLight() throws IOException {
        if (firstRoomLightView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-light.fxml")));
            loader.setController(firstRoomLightController);
            firstRoomLightView = loader.load();
        }

        setStageTitle("The Haunted Mansion: Room One");
        currentView.set(firstRoomLightView);
    }

    public void showFirstRoomPaintings() throws IOException {
        if (firstRoomPaintings == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-paintings.fxml")));
            loader.setController(paintingsController);
            firstRoomPaintings = loader.load();
        }

        setStageTitle("The Haunted Mansion: Room One - The Paintings");
        currentView.set(firstRoomPaintings);
    }

    public void showFirstRoomBookshelf() throws IOException {
        if (firstRoomBookshelf == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-bookshelf.fxml")));
            loader.setController(bookshelfController);
            firstRoomBookshelf = loader.load();
        }

        setStageTitle("The Haunted Mansion: Room One - The Bookshelf");
        currentView.set(firstRoomBookshelf);
    }

    public void setGameIntroSize(Stage stage) {
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);
    }

    public void setRoomSize() {
        stage.setMinWidth(800);
        stage.setMaxWidth(800);
        stage.setMinHeight(435);
        stage.setMaxHeight(435);
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

    public Parent getFirstRoomDarkView() {
        return firstRoomDarkView;
    }

    public Parent getFirstRoomLightView() {
        return firstRoomLightView;
    }

    public Parent getFirstRoomPaintings() {
        return firstRoomPaintings;
    }

    public Parent getFirstRoomBookshelf() {
        return firstRoomBookshelf;
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
