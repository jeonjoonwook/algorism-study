package com.company.hongyeongjune.week12;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int answer = sum;

        for (int i = 1; i <= k; i++) {
            sum = sum - cardPoints[k - i] + cardPoints[cardPoints.length - i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

}

