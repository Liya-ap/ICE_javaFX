module ICE_JAVAFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens main;
    opens view;
    opens model.entity;
    opens controller.firstRoom;
    opens controller.gameIntro;
}