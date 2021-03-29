package com.company.hongyeongjune.week13;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

        if(nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length)
            return -1;

        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(sum1 < sum2) {
            return minOperations(sum1, sum2, nums1, nums2);
        }
        else return minOperations(sum2, sum1, nums2, nums1);

    }

    private int minOperations(int sum1, int sum2, int[] nums1, int[] nums2) {

        int left = 0;
        int right = nums2.length-1;

        int answer = 0;

        while(sum1 < sum2) {

            if(right < 0 || left < nums1.length && 6 - nums1[left] > nums2[right] - 1) {
                sum1 += (6 - nums1[left++]);
            }
            else {
                sum2 -= (nums2[right--] - 1);
            }
            answer++;
        }

        return answer;
    }
}
