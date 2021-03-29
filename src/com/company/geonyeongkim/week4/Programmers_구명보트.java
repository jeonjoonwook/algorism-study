package com.company.geonyeongkim.week4;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-01-23
 */
public class Programmers_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 1;

        Arrays.sort(people);

        int right = people.length -1, left = 0;

        while(true) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            if(left > right) break;
            answer++;
        }
        return answer;
    }
}
