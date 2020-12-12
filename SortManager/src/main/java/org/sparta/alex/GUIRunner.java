package org.sparta.alex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIRunner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/frontpage.fxml"));
        primaryStage.setTitle("Sort Manager");
        primaryStage.setScene(new Scene(root, 590, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
