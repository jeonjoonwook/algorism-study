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
        long answerVal = Long.MAX_VALUE;
        for(int i = 0 ; i < N-2 ; i++){
            int start = i+1, end = N-1;
            while(start < end){
                long sum = arr[i] + arr[start] + arr[end];
                if (Math.abs(sum) < answerVal) {
                    answerArr[0] = arr[start];
                    answerArr[1] = arr[i];
                    answerArr[2] = arr[end];
                    answerVal = Math.abs(sum);
                }
                if(sum < 0)
                    start++;
                else
                    end--;
            }
        }
        System.out.println(Arrays.toString(answerArr));
    }
}