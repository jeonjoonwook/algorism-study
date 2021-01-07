package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());
        long start = 1, end = N * N;
        long answer = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int i = 1; i <= N ; i++){ 
                cnt += Math.min(mid / i , N); //핵심코드! 이분탐색을 하기 위해 개수를 구하는 방법
            }
            if(cnt < k){
                start = mid + 1;
            }else{
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}