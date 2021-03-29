package com.company.hongyeongjune.week8;

public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;

        // 이전 인덱스까지 누적 곱을 넣어준다.
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // 반대 방향으로 똑같이 누적 곱을 넣어준다.
        int mul = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            mul *= nums[i];
            answer[i - 1] *= mul;
        }

        return answer;
    }
}
