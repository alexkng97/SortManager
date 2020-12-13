package org.sparta.alex.sortAlgos;

public class SelectionSort implements Sorter{


    @Override
    public int[] sortArray(int[] arrayToSort) {
        int min;
        int minIndex;

        for(int i = 0; i < arrayToSort.length- 1;i++){
            min = arrayToSort[i];
            minIndex = i;

            for(int j = i+1; j < arrayToSort.length ; j++){
                if(arrayToSort[j] < min){
                    min = arrayToSort[j];
                    minIndex = j;
                }
            }

            arrayToSort[minIndex] = arrayToSort[i];
            arrayToSort[i] = min;

        }
        return arrayToSort;
    }
}
