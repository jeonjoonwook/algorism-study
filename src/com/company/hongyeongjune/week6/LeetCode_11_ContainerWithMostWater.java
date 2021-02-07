package com.company.hongyeongjune.week6;

public class Solution {
    public int maxArea(int[] height) {

        int answer = 0;

        int left = 0;
        int right = height.length-1;

        // 투 포인터 알고리즘 사용
        while(left < right) {

            // left 와 right 중에 더 작은 값 * 길이를 했을 때 최댓값을 구한다.
            answer = Math.max(answer, Math.min(height[left], height[right]) * (right - left));

            // left 가 더 작다면 더 큰 값을 찾기 위해 left 를 올리고
            if(height[left] < height[right]) left++;
                // right 가 더 작다면 더 큰 값을 찾기 위해 right 을 낮춘다.
            else right--;
        }

        return answer;
    }
}