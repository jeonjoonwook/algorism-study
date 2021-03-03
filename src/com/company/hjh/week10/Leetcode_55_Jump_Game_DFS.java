package com.company.hjh.week10;

/**
 * DFS로 풀다가 못풀어서 춘소님 코드 참고했습니다 ㅎㅎ
 */
public class Leetcode_55_Jump_Game_DFS {
    public static void main(String[] args) {
        Leetcode_55_Jump_Game_DFS jumpGame = new Leetcode_55_Jump_Game_DFS();
        //int[] nums = {2,3,1,1,4};
        //System.out.println(jumpGame.canJump(nums));

        int[] nums2 = {3,2,3,0,4};
        System.out.println(jumpGame.canJump(nums2));
    }

    final static int POSSIBLE = 1;
    final static int NONE = 0;
    final static int NEGATIVE = -1;
    int[] dp;
    int[] nums;
    public boolean canJump(int[] nums) {
        this.dp = new int[nums.length];
        this.nums = nums;
        int answer = dfs(0);
        return answer == POSSIBLE;
    }

    private int dfs(int idx) {
        if(idx > nums.length-1)
            return NEGATIVE;

        if(idx == nums.length-1)
            return dp[idx] = POSSIBLE;

        if(dp[idx] != NONE)
            return dp[idx];

        for(int i=idx+1;i<=idx+nums[idx];i++){
            if(dfs(i) == POSSIBLE)
                return dp[i] = POSSIBLE;
        }

        return dp[idx] = NEGATIVE;
    }
}
