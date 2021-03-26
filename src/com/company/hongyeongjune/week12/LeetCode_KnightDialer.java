package com.company.hongyeongjune.week12;

import java.util.Arrays;

public class Solution {

    public static int MOD = 1000000007;

    public int knightDialer(int n) {

        int[][] memo = new int[n + 1][10];
        Arrays.fill(memo[1], 1);
        int[][] dialer = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

        for (int step = 2; step <= n; step++) {
            for (int i = 0; i < 10; i++) {
                for (int dial : dialer[i]) {
                    memo[step][i] += memo[step - 1][dial];
                    memo[step][i] %= MOD;
                }
            }
        }

        int answer = 0;
        for (int m : memo[n]) {
            answer += m;
            answer %= MOD;
        }

        return answer;
    }

}
