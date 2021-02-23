package com.company.hongyeongjune.week8.ICT.문제5번;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int numPaths(List<List<Integer>> warehouse) {

        if (warehouse.get(0).get(0) == 0) return 0;

        int m = warehouse.size();
        int n = warehouse.get(0).size();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (warehouse.get(i).get(j) == 0) dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 0) dp[i][j] += dp[i - 1][j] % 1000000007;
                if (j != 0) dp[i][j] += dp[i][j - 1] % 1000000007;
            }
        }

        return dp[m - 1][n - 1] % 1000000007;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        temp.add(1);
        temp.add(1);
        temp.add(0);
        temp.add(1);

        list.add(temp);
        List<Integer> temp2 = new ArrayList<>();

        temp2.add(1);
        temp2.add(1);
        temp2.add(1);
        temp2.add(1);
        list.add(temp2);
        System.out.println(numPaths(list));

    }
}
