package org.sparta.alex.starter;


import org.sparta.alex.sortAlgos.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class CommandLineStarter {

    private static void printSelectionMessage() {
        System.out.println("Please enter number of the sorting algorithm you wish to choose: \n ");
        System.out.println("1. Binary Tree Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Selection Sort");
    }

    private static int[] callAlgorithm(int algoSelection, int[] randomArray) {
        

        switch(algoSelection){
            case 1:
                BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
                System.out.println("Using Binary Tree Sort...");
                return binaryTreeSort.sortArray(randomArray);
            case 2:
                BubbleSort bubbleSort = new BubbleSort();
                System.out.println("Using Bubble Sort...");
                return bubbleSort.sortArray(randomArray);
            case 3:
                InsertionSort insertionSort = new InsertionSort();
                System.out.println("Using Insertion Sort...");
                return insertionSort.sortArray(randomArray);
            case 4:
                MergeSort mergeSort = new MergeSort();
                System.out.println("Using Merge Sort...");
                return mergeSort.sortArray(randomArray);
            case 5:
                QuickSort quickSort = new QuickSort();
                System.out.println("Using Quick Sort...");
                return quickSort.sortArray(randomArray);
            case 6:
                SelectionSort selectionSort = new SelectionSort();
                System.out.println("Using Selection Sort...");
                return selectionSort.sortArray(randomArray);
        }
        return new int[0];


    }

    public static void main(String[] args) {
        printSelectionMessage();
        Scanner scanner = new Scanner(System.in);

        int algoSelection = scanner.nextInt();
        while (algoSelection < 1 || algoSelection > 6) {
            System.out.println("Please enter a value from 1-6");
            algoSelection = scanner.nextInt();
        }
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();
        while(size < 1) {
            System.out.println("Please enter a valid array size");
            size = scanner.nextInt();
        }
        System.out.println("---------------------------------------------");
        System.out.println("Random Array generated:");
        int [] unsortedArray = RandomArray.generateRandomArray(size);
        int [] unsortedComparision = unsortedArray;

        System.out.println(Arrays.toString(unsortedArray));
        System.out.println("");


        long startTime = System.nanoTime();
        int[] sortedArray = callAlgorithm(algoSelection, unsortedArray);
        long endTime = System.nanoTime();


        System.out.println(Arrays.toString(sortedArray));

        double difference = (endTime - startTime)/1000000.0;

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("\nThat took " + df.format(difference) + " milliseconds to sort!");

        long startTimeComparision = System.nanoTime();
        Arrays.sort(unsortedComparision);
        long endTimeComparision = System.nanoTime();
        double differenceComparision = (endTimeComparision - startTimeComparision)/1000000.0;

        double finalComparision =  difference - differenceComparision;

        System.out.println("Java's own sort method was "+ df.format(finalComparision) + " milliseconds faster!");

    }

}
