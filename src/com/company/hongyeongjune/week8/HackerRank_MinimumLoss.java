package com.company.hongyeongjune.week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {

        long answer = Long.MAX_VALUE;

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < price.length; i++)
            map.put(price[i], i);


        Arrays.sort(price);

        for (int i = price.length - 1; i > 0; i--) {
            if (map.get(price[i]) < map.get(price[i - 1]))
                answer = Math.min(answer, price[i] - price[i - 1]);
        }
        return (int) answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

