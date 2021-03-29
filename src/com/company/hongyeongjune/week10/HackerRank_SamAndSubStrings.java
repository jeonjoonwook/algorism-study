package com.company.hongyeongjune.week10;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrings function below.
    public static long MOD = 1000000007;

    static long substrings(String n) {


        long[] dp = new long[n.length()];
        dp[0] = n.charAt(0) - '0';

        long answer = dp[0];

        for(int i=1; i<n.length(); i++) {
            // 그 이전 값에 10을 곱하고 새로 나오는 일의 자리 수와 그 개수만 큼 곱해서 dp에 저장
            dp[i] = (dp[i-1] * 10 + (n.charAt(i)-'0')*(i+1)) % MOD;
            answer += dp[i]%MOD;
        }

        return answer % MOD;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = scanner.nextLine();

        long result = substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

