package com.company;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[]{2, 2}, 3)));
//        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    //이분탐색을 사용하여 해결
    // TimeComplex: O(logn)
    public int[] searchRange(int[] nums, int target) {
        //target의 시작 위치를 알기 위한 이분탐색
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums.length == 0 || left >= nums.length || nums[left] != target)
            return new int[]{-1, 1};

        //target의 끝나는 위치를 알기 위한 이분탐색
        int leftAnswer = left;
        right = nums.length-1;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{leftAnswer, right};
    }
}