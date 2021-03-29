package com.company.hongyeongjune.week11;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> answer = new HashSet<>();

        // 정렬
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            // 정렬된 값 기준으로 투포인터 실행
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (!answer.contains(temp)) answer.add(temp);
                    left++;
                    right--;
                } else if (sum > 0) right--;
                else left++;
            }
        }

        return new ArrayList<>(answer);

    }
}
