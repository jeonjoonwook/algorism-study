package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final static int CARD_MAX_CNT = 3;
    private static int N, M;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;
        for(int i = 0 ; i < N-2 ; i++){
            if(arr[i] > M)
                continue;
            answer = Math.max(answer, solution(i+1, arr[i], 1));
        }
        System.out.println(answer);
    }

    private static int solution(int idx, int sum, int cnt){
        if(cnt == CARD_MAX_CNT)
            return sum;

        if(idx == N) //3장을 무조건 뽑아야한다.
            return -1;

        int answer = 0;
        for(int i = idx ; i < N ; i++){
            if(arr[i] + sum > M)
                continue;
            answer = Math.max(answer, solution(i+1, sum + arr[i], cnt+1));
        }

        return answer;
    }
}