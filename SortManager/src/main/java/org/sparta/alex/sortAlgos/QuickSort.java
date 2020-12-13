package org.sparta.alex.sortAlgos;

import java.util.Arrays;


public class QuickSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {

        return partition(arrayToSort);
    }

    public static int[] partition(int [] array){
        if(array.length <= 1){
            return array;
        }
        int pivot = array[array.length-1];
        int left = 0 , right = array.length -2;

        while(left < right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] >= pivot && right >= 1) {
                right--;
            }

            if(left > right){
                break;
            }
            int hold = array[left];
            array[left] = array[right];
            array[right] = hold;
        }

        int[] leftPartition;
        int[] rightPartition;

        if(left == right){
            //only occurs if array size of 2: pivot is assigned to array[1] and left and right == 0.
            //runs check as (left < right) is never checked, partitions array correctly

            if(array[left] >= pivot){
                leftPartition =Arrays.copyOfRange(array,0,left);
                rightPartition = Arrays.copyOfRange(array,0,array.length-1);
                
            } else{
                leftPartition =Arrays.copyOfRange(array,0,array.length-1);
                rightPartition =Arrays.copyOfRange(array,0,left);

            }

        }else {

            leftPartition = Arrays.copyOfRange(array, 0, left);
            rightPartition = Arrays.copyOfRange(array, left, array.length - 1);
        }

        leftPartition= partition(leftPartition);
        rightPartition = partition(rightPartition);

        int[] both = new int[array.length];
        System.arraycopy(leftPartition, 0, both,0,leftPartition.length);
        int pivotPos = leftPartition.length;
        both[pivotPos] = pivot;
        System.arraycopy(rightPartition,0,both,pivotPos + 1,rightPartition.length);

        return both;
    }


}
