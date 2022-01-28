package org.simple.sender;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {
    //#region start
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource(
                        "views/MainView.fxml")))));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    //#endregion
    //#region main
    public static void main(String[] args) {
        launch(args);
    }
    //#endregion
}