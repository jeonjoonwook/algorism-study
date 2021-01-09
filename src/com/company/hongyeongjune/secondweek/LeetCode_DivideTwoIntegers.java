package com.company.hongyeongjune.secondweek;

public class Solution {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int answer = 0;

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        while (longDividend >= longDivisor) {

            long temp = longDivisor;

            int multiple = 1;

            while (longDividend >= (temp << 1)) {
                multiple <<= 1;
                temp <<= 1;
            }

            longDividend -= temp;
            answer += multiple;
        }

        if ((dividend > 0 && divisor < 0)
                || (dividend < 0 && divisor > 0)) {
            answer *= -1;
        }
        return answer;
    }
}
