package com.company;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextPermutation(new int[]{1, 5, 4, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                break;
            }
            i--;
        }

        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));;
    }
    private void reverse(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}