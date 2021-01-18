package com.company.hongyeongjune.week1;

public class Solution {

    private static int MOD = 20170805;

    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] right = new int[m+1][n+1];
        int[][] down = new int[m+1][n+1];

        right[1][1] = 1;
        down[1][1] = 1;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {

                if(cityMap[i-1][j-1] == 0) {
                    right[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                    down[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                }
                else if(cityMap[i-1][j-1] == 1) {
                    right[i][j] = 0;
                    down[i][j] = 0;
                }
                else if(cityMap[i-1][j-1] == 2) {
                    right[i][j] = right[i][j-1];
                    down[i][j] = down[i-1][j];
                }

            }
        }

        return down[m][n];
    }

}
