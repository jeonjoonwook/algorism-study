package com.company.hongyeongjune.week2;

import java.util.Arrays;

public class Solution {
    public static void nextPermutation(int[] nums) {

        int index = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                index = i;
        }

        if (index == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length - 1; i > index; i--) {

            if (nums[index] < nums[i]) {
                swap(nums, index, i);
                Arrays.sort(nums, index + 1, nums.length);
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
