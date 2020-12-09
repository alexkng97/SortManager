package org.sparta.alex.sortAlgos;

public class QuickSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort.length <=1){
            return arrayToSort;
        }

        int pivot = pickPivot(arrayToSort.length);
    }


    public int pickPivot(int size){
        
    }
}
