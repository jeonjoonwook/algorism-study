package com.company.ingue.firstweek.DivideTwoIntegers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int caseOneResult = solution.divide(0, 1);
        System.out.println("testCase1 : " + (caseOneResult == 0));

        int caseTwoResult = solution.divide(1, 1);
        System.out.println("testCase2 : " + (caseTwoResult == 1));

        int caseThreeResult = solution.divide(10, 3);
        System.out.println("testCase3 : " + (caseThreeResult == 3));

        int caseFourResult = solution.divide(8, 2);
        System.out.println("testCase4 : " + (caseFourResult == 4));

        int caseFiveResult = solution.divide(-8, 2);
        System.out.println("testCase5 : " + (caseFiveResult == -4));

        int caseSixResult = solution.divide(-7, 2);
        System.out.println("testCase6 : " + (caseSixResult == -3));

        int caseSevenResult = solution.divide(-2147483648, -1);
        System.out.println("testCase7 : " + (caseSevenResult == 2147483647));

        int caseEightResult = solution.divide(-2147483648, 2);
        System.out.println("testCase8 : " + (caseEightResult == -1073741824));
    }

    public int divide(int dividend, int divisor) {
        boolean isMinus = calSign(dividend, divisor);
        long quotient = divideByAddWithSub(dividend, divisor);

        if (isMinus) {
            if (quotient == Integer.MAX_VALUE) {
                quotient = Integer.MIN_VALUE;
            } else {
                quotient = -quotient;
            }
        }

        if (quotient > Integer.MAX_VALUE) {
            quotient = Integer.MAX_VALUE;
        }

        return (int) quotient;
    }

    private long divideByAddWithSub(long dividend, long divisor) {
        long quotient = 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long sum = divisor;
        long multiple = 1;

        while (dividend >= divisor) {
            if (dividend > sum) {
                dividend -= sum;
                quotient += multiple;
                sum += sum;
                multiple += multiple;
            } else {
                dividend -= divisor;
                quotient++;
            }
        }

        return quotient;
    }

    public boolean calSign(int dividend, int divisor) {
        return (dividend < 0) ^ (divisor < 0);
    }
}
