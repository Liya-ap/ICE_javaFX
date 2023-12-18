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
import model.firstRoom.Bookshelf;
import model.firstRoom.FirstRoomDark;
import model.firstRoom.FirstRoomLight;
import model.firstRoom.Paintings;
import model.gamIntro.IntroductionPage;
import model.gamIntro.WelcomePage;

import java.io.IOException;
import java.util.Objects;

public class ViewState {
    private final ReadOnlyObjectWrapper<Parent> currentView = new ReadOnlyObjectWrapper<>();
    private Stage stage;
    private Scene scene;
    private Parent gameMenuView;
    private Parent storyIntroView;
    private Parent welcomeView;
    private Parent firstRoomDarkView;
    private Parent firstRoomLightView;
    private Parent firstRoomGameOverView;
    private Parent firstRoomPaintingsView;

    private Parent firstRoomBookshelfView;
    private IntroductionPage introductionPage;
    private WelcomePage welcomePage;

    private FirstRoomDark firstRoomDark;
    private FirstRoomLight firstRoomLight;
    private Paintings paintings;
    private Bookshelf bookshelf;

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
            introductionPage = new IntroductionPage();
        }

        setStageTitle("The Haunted Mansion: The Story");
        currentView.set(storyIntroView);
    }

    public void showWelcomePage() throws IOException {
        if (welcomeView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/welcome-page.fxml")));
            loader.setController(welcomePageController);
            welcomeView = loader.load();
            welcomePage = new WelcomePage();
        }

        setStageTitle("The Haunted Mansion: Brave Soul, Who are you?");
        currentView.set(welcomeView);
    }

    public void showFirstRoomDark() throws IOException {
        if (firstRoomDarkView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-dark.fxml")));
            loader.setController(firstRoomDarkController);
            firstRoomDarkView = loader.load();
            firstRoomDark = new FirstRoomDark();
        }

        setStageTitle("The Haunted Mansion: Room One");
        currentView.set(firstRoomDarkView);
    }

    public  void showFirstRoomGameOver() throws IOException {
        if (firstRoomGameOverView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/game-intro/game-over.fxml")));
            loader.setController(firstRoomDarkController);
            firstRoomGameOverView = loader.load();
        }

        setStageTitle("You died..");
        currentView.set(firstRoomGameOverView);
    }

    public void showFirstRoomLight() throws IOException {
        if (firstRoomLightView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-light.fxml")));
            loader.setController(firstRoomLightController);
            firstRoomLightView = loader.load();
            firstRoomLight = new FirstRoomLight();
        }

        setStageTitle("The Haunted Mansion: Room One");
        currentView.set(firstRoomLightView);
    }

    public void showFirstRoomPaintings() throws IOException {
        if (firstRoomPaintingsView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-paintings.fxml")));
            loader.setController(paintingsController);
            firstRoomPaintingsView = loader.load();
            paintings = new Paintings();
        }

        setStageTitle("The Haunted Mansion: Room One - The Paintings");
        currentView.set(firstRoomPaintingsView);
    }

    public void showFirstRoomBookshelf() throws IOException {
        if (firstRoomBookshelfView == null) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/first-room/first-room-bookshelf.fxml")));
            loader.setController(bookshelfController);
            firstRoomBookshelfView = loader.load();
            bookshelf = new Bookshelf();
        }

        setStageTitle("The Haunted Mansion: Room One - The Bookshelf");
        currentView.set(firstRoomBookshelfView);
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

    public Parent getFirstRoomPaintingsView() {
        return firstRoomPaintingsView;
    }

    public Parent getFirstRoomBookshelfView() {
        return firstRoomBookshelfView;
    }
    public IntroductionPage getIntroductionPage() {
        return introductionPage;
    }

    public WelcomePage getWelcomePage() {
        return welcomePage;
    }

    public FirstRoomDark getFirstRoomDark() {
        return firstRoomDark;
    }
    public FirstRoomLight getFirstRoomLight() {
        return firstRoomLight;
    }

    public Paintings getPaintings() {
        return paintings;
    }
    public Bookshelf getBookshelf() {
        return bookshelf;
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
