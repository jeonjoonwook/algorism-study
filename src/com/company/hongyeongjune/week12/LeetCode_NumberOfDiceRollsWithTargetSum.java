package com.company.hongyeongjune.week12;

import java.util.Arrays;

public class Solution {

    public static int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {

        int[][] memo = new int[d + 1][target + 1];

        for (int[] m : memo)
            Arrays.fill(m, -1);

        return dp(d, f, target, memo) % MOD;
    }

    private int dp(int d, int f, int target, int[][] memo) {


        if (d == 0 && target == 0)
            return 1;
        if (d == 0 || target < 0)
            return 0;
        if (memo[d][target] != -1) {
            return memo[d][target];
        }

        int answer = 0;

        for (int i = 1; i <= f; i++) {
            answer = (answer + dp(d - 1, f, target - i, memo)) % MOD;
        }

        return memo[d][target] = answer;
    }
}
