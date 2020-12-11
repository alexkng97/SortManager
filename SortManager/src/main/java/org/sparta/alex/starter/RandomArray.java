package org.sparta.alex.starter;

public class RandomArray {

    public static int[] generateRandomArray(int size){
        int[] result = new int[size];

        for(int i = 0; i < size; i++){
            result[i] =  (int)(Math.random() * 100 + 1);

        }

        return result;
    }

}
