package com.company.hongyeongjune.week4;

public class Solution {

    public int trap(int[] height) {

        int answer = 0;
        // 왼쪽 인덱스
        int left = 0;
        // 오른쪽 인덱스
        int right = height.length - 1;

        if (height.length == 0) return 0;
        // 왼쪽에서부터 오는 가장 큰 높이
        int leftHeightMax = height[left];
        // 오른쪽에서부터 오는 가장 큰 높이
        int rightHeightMax = height[right];

        while (left < right) {

            // 왼쪽에서부터 오는 가장 큰 높이 <= 오른쪽에서부터 오는 가장 큰 높이
            if (leftHeightMax <= rightHeightMax) {
                // 가장 큰 높이에서 현재 값을 빼주면 물을 담을 수 있는 만큼의 공간을 알 수 있다.
                // -> 오른쪽에서부터 오는 가장 큰 높이가 왼쪽에서부터 오는 가장 큰 높이보다 크기 때문에 담을 수 있음을 알 수 있다.
                answer += (leftHeightMax - height[left]);
                // 왼쪽 인덱스 하나 늘려주기
                left++;
                // 가장 큰 높이 결정
                leftHeightMax = Math.max(leftHeightMax, height[left]);
            }
            // 왼쪽에서부터 오는 가장 큰 높이 > 오른쪽에서부터 오는 가장 큰 높이
            else {
                // 가장 큰 높이에서 현재 값을 빼주면 물을 담을 수 있는 만큼의 공간을 알 수 있다.
                // -> 왼쪽에서부터 오는 가장 큰 높이가 오른쪽에서부터 오는 가장 큰 높이보다 크기 때문에 담을 수 있음을 알 수 있다.
                answer += (rightHeightMax - height[right]);
                // 오른쪽 인덱스 하나 내려주기
                right--;
                // 가장 큰 높이 결정
                rightHeightMax = Math.max(rightHeightMax, height[right]);
            }

        }

        return answer;
    }

}

