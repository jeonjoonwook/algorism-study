package com.company.hongyeongjune.week11;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int answer = Integer.MAX_VALUE;

        // 정렬
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // 정렬된 값 기준으로 투 포인터 실행
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(answer)) {
                    answer = sum - target;
                } else if (sum > target) right--;
                else left++;

            }
        }

        return target + answer;
    }
}

