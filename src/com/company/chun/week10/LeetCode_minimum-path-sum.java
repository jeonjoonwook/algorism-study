class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        memo[0][0] = grid[0][0];
        for(int i = 1 ; i < grid.length ; i++){
            memo[i][0] = memo[i-1][0] + grid[i][0];
        }
        for(int i = 1 ; i < grid[0].length ; i++){
            memo[0][i] = memo[0][i-1] + grid[0][i];
        }
        for(int r = 1 ; r < grid.length ; r++){
            for(int c = 1 ; c < grid[0].length ; c++){
                memo[r][c] = Math.min(memo[r-1][c], memo[r][c-1]) + grid[r][c];
            }
        }
        return memo[grid.length-1][grid[0].length-1];
    }
}