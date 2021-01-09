package com.company.hongyeongjune.secondweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] answer = new int[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] testCase = new int[T];

        for (int i = 0; i < T; i++) {
            testCase[i] = dp(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < T; i++) {
            System.out.println(testCase[i]);
        }

    }

    public static int dp(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (answer[n] > 0) return answer[n];
        return answer[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
}
