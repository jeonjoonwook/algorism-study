package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] answerArr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0, end = N - 1;
        long answerVal = Long.MAX_VALUE;
        while (start < end) {
            long tmpVal = 0, tmpAbs = Long.MAX_VALUE;
            long l = arr[start] + arr[end];
            for (int i = start + 1; i < end; i++) {
                long sum = l + arr[i];
                long sumAbs = Math.abs(sum);
                if (sumAbs < answerVal) {
                    answerArr[0] = arr[start];
                    answerArr[1] = arr[i];
                    answerArr[2] = arr[end];
                    answerVal = sumAbs;
                }
                if(sumAbs < tmpAbs){
                    tmpAbs = sumAbs;
                    tmpVal = sum;
                }
            }
            if (tmpVal > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(Arrays.toString(answerArr));
    }
}