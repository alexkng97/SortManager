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
        long startTime, endTime;
        double difference;
        int[] originalArray = randomArray;

        switch(algoSelection){
            case 1:
                BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
                System.out.println("Using Binary Tree Sort...");
                startTime = System.nanoTime();
                randomArray =  binaryTreeSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;

            case 2:
                BubbleSort bubbleSort = new BubbleSort();
                System.out.println("Using Bubble Sort...");
                startTime = System.nanoTime();
                randomArray = bubbleSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;

            case 3:
                InsertionSort insertionSort = new InsertionSort();
                System.out.println("Using Insertion Sort...");
                startTime = System.nanoTime();
                randomArray = insertionSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;

            case 4:
                MergeSort mergeSort = new MergeSort();
                System.out.println("Using Merge Sort...");
                startTime = System.nanoTime();
                randomArray = mergeSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;

            case 5:
                QuickSort quickSort = new QuickSort();
                System.out.println("Using Quick Sort...");
                startTime = System.nanoTime();
                randomArray= quickSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;

            case 6:
                SelectionSort selectionSort = new SelectionSort();
                System.out.println("Using Selection Sort...");
                startTime = System.nanoTime();
                randomArray = selectionSort.sortArray(randomArray);
                endTime = System.nanoTime();
                difference = (endTime - startTime)/1000000.0;
                printSortedAndTimings(randomArray,difference,originalArray);
                break;
        }
        return new int[0];

    }

    public static void printSortedAndTimings(int [] sorted, double timing, int[] unsorted){
        System.out.println(Arrays.toString(sorted));
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("\nThat took " + df.format(timing) + " milliseconds to sort!");

        long startTimeComparision = System.nanoTime();
        Arrays.sort(unsorted);
        long endTimeComparision = System.nanoTime();
        double differenceComparision = (endTimeComparision - startTimeComparision)/1000000.0;

        double finalComparision =  timing - differenceComparision;
        StringBuilder sb = new StringBuilder();
        String fasterOrSlower = "faster";

        if(finalComparision < 0){
            finalComparision *= -1;
            fasterOrSlower = "slower";
        }

        sb.append("Java's own sort method was ").append(df.format(finalComparision)).append(" milliseconds ")
                .append(fasterOrSlower).append("!");

        System.out.println(sb.toString());
    }

    public static void start(){
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
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println("");

        callAlgorithm(algoSelection,unsortedArray);

    }

}
