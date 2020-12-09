package org.sparta.alex.binarytree;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
        Node root = new Node(5);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.addElement(10);
        System.out.println("Is root right child empty? " + root.isRightChildEmpty());
        System.out.println(binaryTree.getNumberOfElements());

        int[] toAdd = {1,2,4,11,7};
        binaryTree.addElements(toAdd);
        System.out.println(binaryTree.getNumberOfElements());

        System.out.println(binaryTree.findElement(2));
        System.out.println(Arrays.toString(binaryTree.getSortedTreeAsc()));

        System.out.println(Arrays.toString(binaryTree.getSortedTreeDesc()));


    }

}
