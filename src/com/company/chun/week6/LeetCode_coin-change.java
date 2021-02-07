class Solution {
    private static final int MAX_VAL = 100001;
    private int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        Arrays.sort(coins);
        memo = new int[amount+1];
        Arrays.fill(memo, MAX_VAL);
        memo[0] = 0;
        for (int coin : coins) {
            int idx = coin;
            while (idx <= amount) {
                memo[idx] = Math.min(memo[idx], memo[idx - coin] + 1);
                idx++;
            }
        }
        if(memo[amount] == MAX_VAL)
            return -1;
        return memo[amount];
    }
}