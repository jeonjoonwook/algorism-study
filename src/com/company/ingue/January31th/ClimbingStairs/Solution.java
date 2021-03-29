package com.company.ingue.January31th.ClimbingStairs;

public class Solution {

    /**
     * 시간복잡도 : O(N)
     * 공간복잡도 : O(N)
     *
     * n층 개수 : n-1층 개수 + n-2층 개수 인것을 활용
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] stairs = new int[n+1];

        if(n > 1) {
            stairs[1] = 1;
        }

        if(n > 2) {
            stairs[2] = 2;
        }

        for(int i = 3; i <= n; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }

        return stairs[n];
    }
}
