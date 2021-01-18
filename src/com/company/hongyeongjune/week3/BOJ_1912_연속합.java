package com.company.hongyeongjune.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = sequence[0];

        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            // dp의 전 값과 현재 값의 합 , 현재 값 비교해서 dp 배열에 담는다.
            dp[i] = Math.max(dp[i - 1] + sequence[i], sequence[i]);
            // dp[i] 값 중 가장 큰 값을 answer 에 넣는다.
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
