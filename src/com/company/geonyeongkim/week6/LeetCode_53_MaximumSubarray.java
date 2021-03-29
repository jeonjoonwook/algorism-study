package com.company.geonyeongkim.week6;

/**
 * Created by geonyeong.kim on 2021-02-04
 */
public class LeetCode_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum;
        for(int i = 0; i < nums.length; i++) {
            sum = nums[i];
            answer = Math.max(answer, sum);
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                answer = Math.max(answer, sum);
            }


        }
        return answer;
    }

    public static void main(String[] args) {
        LeetCode_53_MaximumSubarray maximumSubarray = new LeetCode_53_MaximumSubarray();
        int ans = maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{1});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{0});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{-1});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{-10000});
        System.out.println("ans = " + ans);
    }
}
