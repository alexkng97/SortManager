package org.sparta.alex.sortAlgos;


import org.sparta.alex.binarytree.BinaryTree;
import org.sparta.alex.binarytree.Node;

public class BinaryTreeSort implements Sorter {
    private BinaryTree binaryTree;

    public BinaryTree getBinaryTree() {
        return binaryTree;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        initBinaryTree(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }


    public void initBinaryTree(int[] array){
        binaryTree = new BinaryTree(new Node(array[0]));
        for(int i = 1; i< array.length;i++){
            binaryTree.addElement(array[i]);
        }

    }
}
