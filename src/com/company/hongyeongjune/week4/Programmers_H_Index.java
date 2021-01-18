package com.company.hongyeongjune.week4;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {

        // 정렬
        Arrays.sort(citations);

        int answer = 0;

        for(int i=citations.length-1; i>=0; i--) {
            // 비교 대상
            // => 현재 자신의 값 = h
            // => h 보다 크거나 같은 값의 개수
            int min = Math.min(citations[i], citations.length - i);

            // h 번 이상 인용되고 h번 이하 인용되는 최댓값 찾기
            // 즉, 이 값이 감소되는 지점이 최댓값
            answer = Math.max(answer, min);
        }

        return answer;
    }
}