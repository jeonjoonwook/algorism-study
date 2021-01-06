package com.company.hongyeongjune.secondweek;

public class Solution {
    /**
     * 이중 반복문으로 푸는 방식
     * 시간이 많이 걸렸다.
     */
    public int maxSubArray(int[] nums) {

        int answer = nums[0];

        for(int i=0; i<nums.length; i++) {
            int temp = 0;
            for(int j=0; j<nums.length; j++) {
                temp += nums[j];
                answer = Math.max(answer, temp);
            }
        }

        return answer;
    }

    /**
     * DP로 푸는 방식
     * 시간이 많이 줄었다.
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int answer = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
