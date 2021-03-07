class Solution {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[0] = true;
        for(int i = 0 ; i < nums.length ; i++){
            if(!memo[i])
                continue;
            int len = Math.min(nums.length, i + nums[i] + 1);
            for(int k = i+1 ; k < len ; k++){
                memo[k] = true;
            }
        }
        return memo[nums.length-1];
    }
}