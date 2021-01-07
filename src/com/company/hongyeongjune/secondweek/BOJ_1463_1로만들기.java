package com.company.hongyeongjune.secondweek;

import java.io.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        System.out.println(dp_BottomUp(N));

    }

    public static int dp_TopDown(int N) {
        if(N == 1) return 0;
        if(dp[N] > 0 ) return dp[N];

        dp[N] = dp_TopDown(N-1) + 1;
        if(N%2==0) dp[N] = Math.min(dp[N], dp_TopDown(N/2) + 1);
        if(N%3==0) dp[N] = Math.min(dp[N], dp_TopDown(N/3) + 1);

        return dp[N];
    }

    public static int dp_BottomUp(int N) {
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        return dp[N];
    }
}

