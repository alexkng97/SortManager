package org.sparta.alex.sortAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class QuickSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {

        return partition(arrayToSort);
        //select pivot, place pivot at the end
        //iterate through array swapping elements if they are larger/smaller than pivot
        //split array and partition
        //recursively call partition
        //combine arrays + partition
    }

    public static int[] partition(int [] array){
        if(array.length <= 1){
            return array;
        }
        int pivot = array[array.length-1];
        int left = 0 , right = array.length -2;

        System.out.println("PIVOT: " + pivot);
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
            //runs check as (left < right) is never checked, if array[0] > pivot => right
            //as both are 0, original

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

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(leftPartition));
        System.out.println(Arrays.toString(rightPartition));

        leftPartition= partition(leftPartition);
        rightPartition = partition(rightPartition);

        int[] both = new int[array.length];
        System.arraycopy(leftPartition, 0, both,0,leftPartition.length);
        int pivotPos = leftPartition.length;
        both[pivotPos] = pivot;
        System.arraycopy(rightPartition,0,both,pivotPos + 1,rightPartition.length);

        System.out.println("BOTH:" + Arrays.toString(both) );
        return both;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        //System.out.println(Arrays.toString(qs.sortArray(new int[]{2,5,6,3,2,5,9,8,3})));

        System.out.println(Arrays.toString(qs.sortArray(new int[]{3,1,7,2,8,44,1,53})));

        //System.out.println(Arrays.toString(qs.sortArray(new int[] {7,5})));


    }



}
