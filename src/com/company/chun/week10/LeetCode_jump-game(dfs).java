class Solution {
    final static int POSSIBLE = 1;
    final static int NONE = 0;
    final static int NEGATIVE = -1;
    public boolean canJump(int[] nums) {
        int answer = dfs(nums, new int[nums.length], 0);
        return answer == POSSIBLE;
    }

    private int dfs(int[] nums, int[] memo, int idx){
        if(idx == nums.length-1){
            return memo[idx] = POSSIBLE;
        }
        if(memo[idx] != NONE){
            return memo[idx];
        }
        int len = Math.min(nums.length, idx + nums[idx] + 1);
        for(int i = idx+1 ; i < len ; i++){
            if(dfs(nums,memo, i) == POSSIBLE)
                return memo[idx] = POSSIBLE;
        }
        return memo[idx] = NEGATIVE;
    }
}