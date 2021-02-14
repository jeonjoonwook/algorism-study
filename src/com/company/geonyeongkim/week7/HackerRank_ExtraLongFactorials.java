package com.company.geonyeongkim.week7;

import java.math.BigInteger;

/**
 * Created by geonyeong.kim on 2021-02-08
 */
public class HackerRank_ExtraLongFactorials {
    static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");
        for(int i = 2; i<= n ; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInteger);
    }

    public static void main(String[] args) {
        HackerRank_ExtraLongFactorials.extraLongFactorials(25);
    }
}
