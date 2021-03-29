package com.company.hongyeongjune.week11;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static long MOD = 1000000007;

    // Complete the cost function below.
    static long cost(int[] B) {

        long[][] dp = new long[B.length][2];

        for(int i=1; i<dp.length; i++) {
            // 1을 선택하는 경우
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + (B[i-1] - 1)) % MOD;
            // B[i]를 선택하는 경우
            dp[i][1] = Math.max(dp[i-1][0] + B[i] - 1, dp[i-1][1] + Math.abs(B[i] - B[i-1])) % MOD;
        }

        return Math.max(dp[B.length-1][0], dp[B.length-1][1]) % MOD;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            long result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


