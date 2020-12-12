package org.sparta.alex.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.sparta.alex.sortAlgos.*;
import org.sparta.alex.starter.RandomArray;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ResultsController {


    public TextArea unsortedArrayField;
    public TextArea sortedArrayField;
    public TextArea timings;
    public Button backButton;

    public String sortAlgo;
    public int size;


    public void initialize(){
        unsortedArrayField.setEditable(false);
        sortedArrayField.setEditable(false);
        timings.setEditable(false);
        //System.out.println("init called");


    }


    public void handleBackButtonClicked(ActionEvent actionEvent) throws IOException {

        Parent root = null;
        Scene scene = backButton.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("/frontpage.fxml")));
        root = loader.load();

        Scene home = new Scene(loader.getRoot());

        stage.setScene(home);

    }

    public void transferInfo(String sortAlgo, int size) {
        this.sortAlgo= sortAlgo;
        this.size = size;

        int [] unsortedArray = RandomArray.generateRandomArray(size);
        unsortedArrayField.setText(Arrays.toString(unsortedArray));

        int[] originalArray = unsortedArray;

        double timeTaken = beginSort(unsortedArray);

        timings.setText(getTimings(originalArray,timeTaken));

    }


    public double beginSort(int [] array) {
        long startTime, endTime;

        switch(sortAlgo){
            case "Binary Tree":
                BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
                startTime = System.nanoTime();
                array = binaryTreeSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

            case "Bubble":
                BubbleSort bubbleSort = new BubbleSort();
                startTime = System.nanoTime();
                array = bubbleSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

            case "Insertion":
                InsertionSort insertionSort = new InsertionSort();
                startTime = System.nanoTime();
                array = insertionSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

            case "Merge":
                MergeSort mergeSort = new MergeSort();
                startTime = System.nanoTime();
                array = mergeSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

            case "Quick":
                QuickSort quickSort = new QuickSort();
                startTime = System.nanoTime();
                array = quickSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

            case "Selection":
                SelectionSort selectionSort = new SelectionSort();
                startTime = System.nanoTime();
                array = selectionSort.sortArray(array);
                endTime = System.nanoTime();
                sortedArrayField.setText(Arrays.toString(array));
                return (endTime - startTime)/1000000.0;

        }


        return 0.0;

    }


    public String getTimings(int[] array, double time){
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.###");
        sb.append("That took ").append(df.format(time)).append(" milliseconds to sort!\n");


        long startTimeComparision = System.nanoTime();
        Arrays.sort(array);
        long endTimeComparision = System.nanoTime();
        double differenceComparision = (endTimeComparision - startTimeComparision)/1000000.0;


        double finalComparision =  time - differenceComparision;

        String fasterOrSlower = "faster";

        if(finalComparision < 0){
            finalComparision *= -1;
            fasterOrSlower = "slower";
        }

        sb.append("Java's own sort method was:\n").append(df.format(finalComparision)).append(" milliseconds ")
                .append(fasterOrSlower).append("!");

        return sb.toString();




    }

}
