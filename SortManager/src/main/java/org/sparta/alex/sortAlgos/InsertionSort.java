package org.sparta.alex.sortAlgos;

public class InsertionSort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int temp, j;
         for(int i = 1; i < arrayToSort.length; i++){
            temp = arrayToSort[i];
            j = i -1;
            while (j >= 0 && arrayToSort[j] > temp){
                arrayToSort[j+1] = arrayToSort[j];
                j= j-1;
            }
            arrayToSort[j+1] = temp;

        }

        return arrayToSort;
    }
}
