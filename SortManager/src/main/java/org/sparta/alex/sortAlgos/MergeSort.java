package org.sparta.alex.sortAlgos;

import java.util.Arrays;

public class MergeSort implements Sorter {

    public static int[] mergeArrays(int[] left, int[] right){
        int [] finalArray = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, finalIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex] < right[rightIndex]) {
                finalArray[finalIndex] = left[leftIndex];
                leftIndex++;
            } else {
                finalArray[finalIndex] = right[rightIndex];
                rightIndex++;
            }
            finalIndex++;
        }

        while(leftIndex < left.length){
            finalArray[finalIndex] = left[leftIndex];
            finalIndex++;
            leftIndex++;
        }


        while(rightIndex < right.length){
            finalArray[finalIndex] = right[rightIndex];
            finalIndex++;
            rightIndex++;
        }

        return finalArray;
    }


    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort.length < 2){
            return arrayToSort;
        }
        int midpoint = arrayToSort.length / 2;
        int[] left = new int [midpoint];
        int[] right = new int[arrayToSort.length - midpoint];

        System.arraycopy(arrayToSort, 0 ,left,0, midpoint);
        //System.out.println(Arrays.toString(Arrays.stream(left).toArray()));
        left = sortArray(left);

        System.arraycopy(arrayToSort,midpoint, right,0,arrayToSort.length - midpoint);
        //System.out.println(Arrays.toString(Arrays.stream(right).toArray()));
        right = sortArray(right);

        return mergeArrays(left,right);
    }


}
