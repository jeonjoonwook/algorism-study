package com.company.hongyeongjune.week12;

public class Solution_시간초과 {

    public static int MOD = 1000000007;
    public static long answer;

    public int numRollsToTarget(int d, int f, int target) {

        answer = 0;

        dfs(d, f, target, 0, 0);

        return (int) (answer % MOD);
    }

    public void dfs(int d, int f, int target, int index, int sum) {

        if (index == d && sum == target) {
            answer %= MOD;
            answer++;
            return;
        }

        if (index == d) {
            return;
        }

        for (int i = 1; i <= f && i <= target; i++) {
            dfs(d, f, target, index + 1, sum + i);
        }
    }
}

