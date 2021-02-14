package com.company.hongyeongjune.week7;

public class Solution {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {

        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(char[][] grid, int x, int y) {

        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {

            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }

    }
}
