class Solution {
    final static int MAX_VAL = 100001;
    int[] memo, arr;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;

        memo = new int[amount+1];
        Arrays.fill(memo, MAX_VAL);
        arr = coins;
        int answer = dfs(amount);
        if(answer == MAX_VAL)
            return -1;
        return answer;
    }
    
    private int dfs(int amount){
        if(amount == 0)
            return 0;

        if(memo[amount] != MAX_VAL)
            return memo[amount];

        for (int j : arr) {
            if (j > amount)
                continue;
            memo[amount] = Math.min(memo[amount], dfs(amount - j) + 1);
        }

        return memo[amount];
    }
}