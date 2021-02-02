package com.company.hongyeongjune.week6;

public class Solution {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int answer = nums[0];
        for(int i=1; i<nums.length; i++) {
            // dp 에 저장된 값에 현재 값을 더한거랑 현재 값을 비교해서 최대 값을 찾는다.
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            // answer 에는 dp 값과 answer 값을 비교해서 최대 값을 담는다.
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
