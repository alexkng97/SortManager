package org.sparta.alex.binarytree;

import java.util.ArrayList;

public class BinaryTree implements BinaryTreeInterface{
    private final Node rootNode;
    private int size;
    
    public BinaryTree(Node rootNode){
        this.rootNode = rootNode;
        this.size = 1;
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return size;
    }

    @Override
    public void addElements(int[] elements) {
        for(int number : elements){
            addElement(number);
        }
    }

    public void addElement(final int element){
        size++;
        addNodeToTree(rootNode,element);
    }



    private void addNodeToTree(Node node, int element) {
        if(element == node.getValue()){
            //haven't implemented duplicate values, wont be added to tree => size--;
            size--;
            return;
        }

        if(element < node.getValue()){
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node (element));
            }else{
                addNodeToTree(node.getLeftChild(),element);
            }
        } else if(element > node.getValue()){
            if(node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
            } else{
                addNodeToTree(node.getRightChild(),element);
            }
        }

    }

    public Node findNode(final int element){
        Node node = rootNode;
        while (node != null){
            if(element == node.getValue()){
                return node;
            }

            if(element < node.getValue()){
                node = node.getLeftChild();
            }else{
                node = node.getRightChild();
            }
        }
        return null;
    }


    @Override
    public boolean findElement(int value) {
        return findNode(value) != null;
    }

    @Override
    public int[] getSortedTreeAsc() {
        Node node = rootNode;
        ArrayList<Integer> inOrder = new ArrayList<>();
        ascTraverse(node,inOrder);
        return inOrder.stream().mapToInt(i -> i).toArray();
    }

    public void ascTraverse(Node node, ArrayList<Integer> inOrder){
        if (node != null) {
            ascTraverse(node.getLeftChild(),inOrder);
            inOrder.add(node.getValue());
            ascTraverse(node.getRightChild(),inOrder);
        }

    }

    @Override
    public int[] getSortedTreeDesc() {
        ArrayList<Integer> descendingOrder = new ArrayList<>();
        descTraverse(rootNode, descendingOrder);
        return descendingOrder.stream().mapToInt(i -> i).toArray();
    }

    public void descTraverse(Node node, ArrayList<Integer> descendingOrder){
        if(node != null){
            descTraverse(node.getRightChild(),descendingOrder);
            //System.out.println(node.getValue());
            descendingOrder.add(node.getValue());
            descTraverse(node.getLeftChild(),descendingOrder);
        }
    }

}
