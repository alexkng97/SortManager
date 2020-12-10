package org.sparta.alex.presentation;

import java.util.Scanner;

public class CommandLineInput {

    public static void printSelectionMessage(){
        System.out.println("Please enter number of the sorting algorithm you wish to choose: \n ");
        System.out.println("1. Binary Tree Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Selection Sort");
    }


    public static void main(String[] args) {
        printSelectionMessage();
        Scanner scanner = new Scanner(System.in);

        int algoSelection = scanner.nextInt();
        while(algoSelection < 1 || algoSelection > 6){
            System.out.println("Please enter a value from 1-6");
            algoSelection = scanner.nextInt();
        }


    }



}
