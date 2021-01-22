package com.company.hongyeongjune.week4;

public class Main {

    public static int N = 4;
    public static int INF = Integer.MAX_VALUE;

    public static int[][] dp = {
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };

    public static void main(String[] args) {
        floydWarshall();
    }

    public static void floydWarshall() {

        // k : 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i : 출발 노드
            for (int i = 0; i < N; i++) {
                // j : 도착 노드
                for (int j = 0; j < N; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
    }
}
