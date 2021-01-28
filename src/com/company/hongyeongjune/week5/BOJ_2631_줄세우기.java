package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        for(int i=0; i<N; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            // 시작은 무조건 1
            dp[i] = 1;
            // j = 0 부터 기준 값 i까지 반복
            for(int j=0; j<i; j++) {
                // i 보다 작은 index 를 가진 값 중 i보다 작은 값이 있고,
                // dp[i] 값이 그 이전에 저장된 dp[j] + 1 보다 작다면,
                // dp[i] 에 1 이전에 저장된 값에서 + 1 을 해준다.
                if(line[j] < line[i] && dp[i] < dp[j]+1) {

                    dp[i] = dp[j] + 1;
                }
            }
            // 가장 큰 값 저장하기
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
