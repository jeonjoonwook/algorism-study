class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int answer = nums[0];
        memo[0] = nums[0];
        for(int i = 1; i < nums.length ; i++){
            memo[i] = Math.max(memo[i-1] + nums[i], nums[i]);
            answer = Math.max(answer, memo[i]);
        }
        return answer;
    }
}