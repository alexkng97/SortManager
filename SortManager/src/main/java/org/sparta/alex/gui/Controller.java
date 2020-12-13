package org.sparta.alex.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Controller {

    public Button sortButton;
    public TextField arraySize;
    public ChoiceBox algo;

    private String sortAlgo;
    private int size;

    public void initialize(){

    }

    public void handleSortButtonClicked(ActionEvent e) throws IOException {
        size = Integer.parseInt(arraySize.getText());
        sortAlgo = (String) algo.getValue();

        Parent root = null;
        Scene scene = sortButton.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("/results.fxml")));
        root = loader.load();

        if(e.getSource() == sortButton) {
            ResultsController resultsController = loader.getController();
            resultsController.transferInfo(sortAlgo,size);
        }

        Scene resultScene = new Scene(loader.getRoot());

        stage.setScene(resultScene);

    }
}
