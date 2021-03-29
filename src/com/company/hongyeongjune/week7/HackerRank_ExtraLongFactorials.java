package com.company.hongyeongjune.week7;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(bigInteger);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}