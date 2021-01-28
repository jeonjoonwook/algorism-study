class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        memo[1][1] = 1;
        for(int r = 1 ; r <= m ; r++){
            for(int c = 1 ; c <= n ; c++){
                memo[r][c] += memo[r-1][c] + memo[r][c-1];
            }
        }
        return memo[m][n];
    }
}