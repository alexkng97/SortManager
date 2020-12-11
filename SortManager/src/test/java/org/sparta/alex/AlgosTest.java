package org.sparta.alex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sparta.alex.presentation.RandomArray;
import org.sparta.alex.sortAlgos.*;

import java.util.Arrays;

public class AlgosTest {
    int[] sortedArray = new int[]{1,2,3,4,5,7,8,10};
    int[] unsorted = new int[]{3,1,7,10,8,4,5,2};

    @Test
    public void initBinaryTree(){
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.initBinaryTree(new int[]{10,21,31,2});
        Assertions.assertEquals(10, binaryTreeSort.getBinaryTree().getRootElement());
    }

    @Test
    public void binaryTreeSort(){
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        Assertions.assertEquals(Arrays.toString(sortedArray), Arrays.toString(binaryTreeSort.sortArray(unsorted)));
    }

    @Test
    public void bubbleSortTest(){
        BubbleSort bubbleSort = new BubbleSort();
        Assertions.assertEquals(Arrays.toString(sortedArray), Arrays.toString(bubbleSort.sortArray(unsorted)));
    }

    @Test
    public void mergeSortTest(){
        MergeSort mergeSort = new MergeSort();
        Assertions.assertEquals(Arrays.toString(sortedArray), Arrays.toString(mergeSort.sortArray(unsorted)));
    }

    @Test
    public void insertionSortTest(){
        InsertionSort insertionSort = new InsertionSort();
        Assertions.assertEquals(Arrays.toString(sortedArray),Arrays.toString(insertionSort.sortArray(unsorted)));
    }

    @Test
    public void quickSortTest(){
        QuickSort quickSort = new QuickSort();
        Assertions.assertEquals(Arrays.toString(sortedArray), Arrays.toString(quickSort.sortArray(unsorted)));
    }

    @Test
    public void selectionSortTest(){
        SelectionSort selectionSort = new SelectionSort();
        Assertions.assertEquals(Arrays.toString(sortedArray),Arrays.toString(selectionSort.sortArray(unsorted)));
    }

    public void binarySortWithRandom(){
        BinaryTreeSort bs = new BinaryTreeSort();
        int [] randomArray = RandomArray.generateRandomArray(10);
        
        Assertions.assertEquals()
    }


}
