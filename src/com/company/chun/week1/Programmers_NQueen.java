import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4));
    }

    private int n;
    private int[] map;
    public int solution(int n) {
        this.n = n;
        map = new int[n];
        Arrays.fill(map, -1);
        return dfs(0);
    }

    private int dfs(int row) {
        if (row == n)
            return 1;

        int answer = 0;
        for(int column = 0 ; column < n ; column++){
            if (!check(row, column))
                continue;
            map[row] = column;
            answer += dfs(row + 1);
            map[row] = -1;
        }
        return answer;
    }

    private boolean check(int r, int c) {
        for (int i = 0; i < n; i++) {
            if(map[i] == -1)
                continue;
            if (map[i] == c)
                return false;
            if (Math.abs(r - i) == Math.abs(c - map[i]))
                return false;
        }

        return true;
    }
}