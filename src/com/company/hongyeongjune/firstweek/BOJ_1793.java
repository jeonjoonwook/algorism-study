package com.company.hongyeongjune.firstweek;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static BigInteger[] d = new BigInteger[1001];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            System.out.println(dp(x));
        }

    }

    private static BigInteger dp(int x) {
        if (x == 0) return BigInteger.valueOf(1);
        if (x == 1) return BigInteger.valueOf(1);
        if (x == 2) return BigInteger.valueOf(3);
        if (d[x] != null) return d[x];
        return d[x] = (
                dp(x - 1).add(
                        dp(x - 2).multiply(
                                BigInteger.valueOf(2)
                        )
                )
        );
    }
}

