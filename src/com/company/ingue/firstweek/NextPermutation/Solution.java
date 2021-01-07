package com.company.ingue.firstweek.NextPermutation;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] firstTestCase = {1, 2, 3};
        int[] firstExpectOutput = {1, 3, 2};

        int[] firstOutput = solution.nextPermutation(firstTestCase);
        System.out.println("firstCase : " + Arrays.equals(firstOutput, firstExpectOutput));

        int[] secondTestCase = {4, 3, 2, 1};
        int[] secondExpectOutput = {1, 2, 3, 4};

        int[] secondOutput = solution.nextPermutation(secondTestCase);
        System.out.println("secondCase : " + Arrays.equals(secondOutput, secondExpectOutput));

        int[] thirdTestCase = {1};
        int[] thirdExpectOutput = {1};

        int[] thirdOutput = solution.nextPermutation(thirdTestCase);
        System.out.println("thirdCase : " + Arrays.equals(thirdOutput, thirdExpectOutput));

        int[] fourthTestCase = {1, 1, 5, 5};
        int[] fourthExpectOutput = {1, 5, 1, 5};

        int[] fourthOutput = solution.nextPermutation(fourthTestCase);
        System.out.println("fourthCase : " + Arrays.equals(fourthOutput, fourthExpectOutput));

        int[] fivethTestCase = {1, 2};
        int[] fivethExpectOutput = {2, 1};

        int[] fivethOutput = solution.nextPermutation(fivethTestCase);
        System.out.println("fivethCase : " + Arrays.equals(fivethOutput, fivethExpectOutput));

        int[] sixthTestCase = {1, 4, 3, 2};
        int[] sixthExpectOutput = {2, 1, 3, 4};

        int[] sixthOutput = solution.nextPermutation(sixthTestCase);
        System.out.println("sixthCase : " + Arrays.equals(sixthOutput, sixthExpectOutput));

        int[] seventhTestCase = {1, 1, 5};
        int[] seventhExpectOutput = {1, 5, 1};

        int[] seventhOutput = solution.nextPermutation(seventhTestCase);
        System.out.println("seventhCase : " + Arrays.equals(seventhOutput, seventhExpectOutput));

        int[] eiethTestCase = {1, 5, 1};
        int[] eiethExpectOutput = {5, 1, 1};

        int[] eiethOutput = solution.nextPermutation(eiethTestCase);
        System.out.println("seventhCase : " + Arrays.equals(eiethOutput, eiethExpectOutput));
    }

    public int[] nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int left = nums.length - 2;
        int right = nums.length - 1;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left == -1) {
            Arrays.sort(nums);

            return nums;
        }

        while(nums[left] >= nums[right]) {
            right--;
        }

        swap(nums, left, right);

        Arrays.sort(nums, left + 1, nums.length);

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
