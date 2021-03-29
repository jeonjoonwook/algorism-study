package com.company.ingue.firstweek.kthNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.runAlgorithm();
    }

    public void runAlgorithm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());

        int[][] array = new int[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }

        int k = Integer.parseInt(br.readLine());
        System.out.println(findKthNum(array, k));
    }

    private int findKthNum(int[][] array, int k) {
        int[] first = array[0];

        for (int i = 1; i < array.length; i++) {
            int[] second = array[i];

            first = merge(first, second);
        }

        return first[k-1];
    }

    private int[] merge(int[] first, int[] second) {
        int[] returnArray = new int[first.length+second.length];

        int left = 0;
        int right = 0;
        int returnIndex = 0;

        while(left < first.length && right < second.length) {
            if(first[left] >= second[right]) {
                returnArray[returnIndex++] = second[right++];
            } else {
                returnArray[returnIndex++] = first[left++];
            }
        }

        if(left == first.length) {
            for(int i = right; i < second.length; i++) {
                returnArray[returnIndex++] = second[i];
            }
        }

        if(right == second.length) {
            for(int i = left; i < first.length; i++) {
                returnArray[returnIndex++] = first[i];
            }
        }

        return returnArray;
    }
}
