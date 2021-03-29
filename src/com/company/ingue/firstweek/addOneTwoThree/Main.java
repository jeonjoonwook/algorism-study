package com.company.ingue.firstweek.addOneTwoThree;

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

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            System.out.println(addOneTwoThree(num));
        }
    }

    private int addOneTwoThree(int num) {
        int[] store = new int[num + 1];

        store[1] = 1;
        if (num >= 2) store[2] = 2;
        if (num >= 3) store[3] = 4;

        for (int i = 4; i <= num; i++) {
            store[i] = store[i - 1] + store[i - 2] + store[i - 3];
        }

        return store[num];
    }
}
