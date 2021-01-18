package com.company.hongyeongjune.week4;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int answer = 0;

        while(left <= right) {
            // 무조건 2개 씩 담을 수 있으므로 가장 큰 값과 작은 값을 합치면 오른쪽으로 이동
            if(people[left] + people[right] <= limit) left++;
            // 2개씩 못 담으면 왼쪽으로 이동하고 값을 하나 늘림
            right--;
            answer++;
        }

        return answer;
    }
}

