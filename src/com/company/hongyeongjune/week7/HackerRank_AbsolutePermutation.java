package com.company.hongyeongjune.week7;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {

        int[] answer = new int[n];

        // k 가 0 이면 그냥 순서대로 넣으면 된다.
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = i + 1;
            }
            return answer;
        }

        // 규칙
        // 각 자리수에 K 를 K번 만큼 더하고, K번 만큼 빼는 것이 반복되어야한다.
        // EX)
        // 1+4 = 5
        // 2+4 = 6
        // 3+4 = 7
        // 4+4 = 8
        // 5-4 = 1
        // 6-4 = 2
        // 7-4 = 3
        // 8-4 = 4
        // -> 이렇게 되지 않는 경우는 무조건 -1을 return 한다.
        if (n % (2 * k) != 0) return new int[]{-1};

        // 위의 규칙을 적용해서 각 자리수를 k로 나눴을 때 k번 만큼 + - 를 반복하려면
        // 다음과 같은 조건을 사용하면 된다.
        for (int i = 0; i < n; i++) {
            if ((i / k) % 2 == 0) answer[i] = i + k + 1;
            else answer[i] = i - k + 1;
        }

        return answer;
    }

    private static boolean absolutePermutationCheck(int[] value, int k) {

        for (int i = 1; i < value.length; i++) {
            if (Math.abs(value[i] - i) != k) return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

