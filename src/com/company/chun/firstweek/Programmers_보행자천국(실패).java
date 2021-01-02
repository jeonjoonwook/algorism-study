import java.util.Arrays;
class Solution {
  int MOD = 20170805;
    long[][] memo;
    int[][] MAP;
    int M, N;
    public int solution(int m, int n, int[][] cityMap) {
        M = m; N = n; MAP = cityMap;
        memo = new long[M][N];
        for(int i = 0 ; i < m ; i++)
            Arrays.fill(memo[i], -1);


        long val1 = dfs(0, 0) %MOD;

        return (int) memo[0][0];
    }

    public long dfs(int x, int y){
        if(x >= M || y >= N)
            return 0;
        if(x == M-1 && y == N-1)
            return 1;

        if(memo[x][y] != -1)
            return memo[x][y];

        memo[x][y] = 0;
        if(x+1 < M){
            if(MAP[x+1][y] == 0)
                memo[x][y] += dfs(x+1, y) % MOD;
            else if(MAP[x+1][y] == 1)
                memo[x][y] = 0;
            else if (MAP[x+1][y] == 2)
                memo[x][y] += dfs(x+2, y) % MOD;
        }
        if(y+1 < N){
            if(MAP[x][y+1] == 0)
                memo[x][y] += dfs(x, y+1) % MOD;
            else if(MAP[x][y+1] == 1)
                memo[x][y] += 0;
            else if(MAP[x][y+1] == 2)
                memo[x][y] += dfs(x, y+2) % MOD;
        }
        return memo[x][y];
    }
}