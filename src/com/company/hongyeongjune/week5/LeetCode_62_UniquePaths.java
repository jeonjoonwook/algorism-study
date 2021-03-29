package com.company.hongyeongjune.week5;

public class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        // 0열로 가는 방법은 무조건 1
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        // 0행으로 가는 방법은 무조건 1
        for(int i=0; i<n; i++) {
            dp[0][i] = 1;
        }

        // 위쪽 왼쪽에서 올 수 있으므로 계속 더해준다.
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
