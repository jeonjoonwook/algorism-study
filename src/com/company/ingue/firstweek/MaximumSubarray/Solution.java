package com.company.ingue.firstweek.MaximumSubarray;

public class Solution {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int temp = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (temp > 0 && (temp + nums[i] > 0)) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }

            if (temp > result) {
                result = temp;
            }
        }

        return result;
    }
}
