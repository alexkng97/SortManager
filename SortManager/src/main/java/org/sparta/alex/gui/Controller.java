package org.sparta.alex.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    public Button sortButton;
    public TextField arraySize;
    public ChoiceBox algo;



    public void initialize(){


    }

    public void handleSortButtonClicked(ActionEvent actionEvent){
        int size = Integer.parseInt(arraySize.getText());
        System.out.println("size entered:" + size);
        String sortAlgo = (String) algo.getValue();
        System.out.println("algo: " + sortAlgo);



    }
}
