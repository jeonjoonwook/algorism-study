package com.company.ingue.firstweek.makeToOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.runAlgorithm();
    }

    public void runAlgorithm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int inputNum = Integer.parseInt(line);
        int[] store = new int[inputNum+1];
        Arrays.fill(store, -1);

        System.out.println(makeToOne(inputNum, store));
    }

    private int makeToOne(int num, int[] store) {
        store[1] = 0;

        for(int i = 2; i <=num; i++) {
            int divideByThree = Integer.MAX_VALUE;
            int divideByTwo = Integer.MAX_VALUE;
            int minusOne = store[i-1];

            if(i % 3 == 0) {
                divideByThree = store[i/3];
            }

            if(i % 2 == 0) {
                divideByTwo = store[i/2];
            }

            store[i] = Math.min(Math.min(divideByThree, divideByTwo), minusOne)+1;
        }

        return store[num];
    }
}
