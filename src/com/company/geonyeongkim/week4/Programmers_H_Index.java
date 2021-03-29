package com.company.geonyeongkim.week4;

/**
 * Created by geonyeong.kim on 2021-01-23
 */
public class Programmers_H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        int max = 0;
        for (int i : citations) {
            max = Math.max(max, i);
        }

        for (int i = max; i >= 0; i--) {
            int cnt = 0;
            for(int j = 0; j< citations.length; j++){
                if(citations[j] >= i) {
                    cnt++;
                }
            }
            if(cnt >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
