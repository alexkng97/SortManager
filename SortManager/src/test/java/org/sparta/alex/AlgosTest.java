package org.sparta.alex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sparta.alex.binarytree.BinaryTree;
import org.sparta.alex.sortAlgos.BinaryTreeSort;

import java.util.Arrays;

public class AlgosTest {

    @Test
    public void initBinaryTree(){
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.initBinaryTree(new int[]{10,21,31,2});
        Assertions.assertEquals(10, binaryTreeSort.getBinaryTree().getRootElement());
    }

    @Test
    public void binaryTreeSort(){
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        Assertions.assertEquals(Arrays.toString(new int[]{ 1,2,3,4,5,7,8,10}) ,
                Arrays.toString(binaryTreeSort.sortArray(new int[]{3,1,7,10,8,4,5,2})));

    }


}
