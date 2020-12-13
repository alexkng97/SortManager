package org.sparta.alex.sortAlgos;

public class BubbleSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {

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
