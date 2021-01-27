package com.company.hongyeongjune.week5;

public class Solution {

    public int climbStairs(int n) {

        int[] dp = new int[10001];
        return recursion(n, 0, dp);

    }

    public int recursion(int n, int sum, int[] dp) {

        if(n < sum) return 0;
        if(n == sum) return 1;
        if(dp[sum] != 0) return dp[sum];
        // 1또는 2씩 늘어나기 때문에
        return dp[sum] = recursion(n, sum+1, dp) + recursion(n, sum+2, dp);
    }

}

