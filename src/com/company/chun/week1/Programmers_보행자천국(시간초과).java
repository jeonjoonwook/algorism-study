import java.util.*;

class Solution {

    private final static int FREE_PASS = 0;
    private final static int NOT_PASS = 1;
    private final static int ONLY_STRAIGHT = 2;
    private final static int MOD = 20170805;

    private int M, N;
    private int[][] map;
    private boolean[][] visited;
    private int[][][] memo;

    public int solution(int m, int n, int[][] cityMap) {
        this.M = m;
        this.N = n;
        this.map = cityMap;

        visited = new boolean[m][n];
        memo = new int[2][m][n];

        return dfs(RIGHT, 0, 0);
    }

    private final static int RIGHT = 0;
    private final static int DOWN = 1;
    int[] dy = {0, 1};
    int[] dx = {1, 0};

    private int dfs(int d, int y, int x) {
        if (y == M - 1 && x == N - 1)
            return 1;

        if (memo[d][y][x] != 0)
            return memo[d][y][x];

        if (map[y][x] == ONLY_STRAIGHT) {
            if (d == RIGHT && check(y, x + 1)) {
                return memo[d][y][x] = dfs(RIGHT, y, x + 1) % MOD;
            } else if (d == DOWN && check(y + 1, x)) {
                return memo[d][y][x] = dfs(DOWN, y + 1, x) % MOD;
            }
            return memo[d][y][x] = 0;
        }

        for (int i = 0; i < dy.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (check(nextY, nextX)) {
                visited[y][x] = true;
                memo[d][y][x] += dfs(i, nextY, nextX) % MOD;
                visited[y][x] = false;
            }
        }
        return memo[d][y][x] % MOD;
    }

    private boolean check(int y, int x) {
        return y >= 0 && y < M
                && x >= 0 && x < N
                && !visited[y][x]
                && map[y][x] != NOT_PASS;
    }

}