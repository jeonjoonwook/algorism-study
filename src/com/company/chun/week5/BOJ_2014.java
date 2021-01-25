package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr=new long[K];
        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            queue.offer(arr[i]);
        }

        long answer = 0;
        while(N-- > 0 && !queue.isEmpty()){
            answer = queue.poll();
            for(int i = 0 ; i < arr.length ; i++){
                queue.offer(answer * arr[i]);
                if(answer % arr[i] == 0)
                    break;
            }
        }
        System.out.println(answer);
    }
}