package com.company.ingue.January31th.UniquePaths;

public class Solution {

    /**
     * 시간복잡도 O(m*n)
     * 공간복잡도 O(m*n)
     *
     * array[i][j] = array[i-1][j] + array[i][j-1] 를 응용
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] pathCountArray = new int[m][n];

        pathCountArray[0][0] = 0;

        for(int i = 1; i < m; i++) {
            pathCountArray[i][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            pathCountArray[0][i] = 1;
        }

        for(int i = 1; i <m; i++) {
            for(int j = 1; j <n; j++) {
                pathCountArray[i][j] = pathCountArray[i-1][j] + pathCountArray[i][j-1];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(pathCountArray[i][j] + " ");
            }
            System.out.println();
        }

        return pathCountArray[m-1][n-1];
    }
}
