package org.sparta.alex.sortAlgos;

import java.util.Arrays;

public class BubbleSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        //1. implement one iteration of swapping postions
        //2. repeat until array sorted

        int numOfSwaps;
        do {
            numOfSwaps = 0;
            for (int i = 0; i < arrayToSort.length - 1; i++) {

                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    numOfSwaps++;
                    int holder = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = holder;
                }
            }
        }while(numOfSwaps != 0);


        return arrayToSort;
    }


}
