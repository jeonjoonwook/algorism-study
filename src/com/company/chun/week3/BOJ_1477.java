package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, L;
    static int[] distance; // 각 이전 휴게소까지의 거리
    static int[][] memo; // r번째 인덱스 구간부터 c개의 휴게소를 지을 때 최대 거리

    //휴개소 N개 시작으로부터 얼마나 떨어져있는지
    //모든 휴게소를 방문, M개 더지어서 휴게소끼리의 구간이 최소가 되도록
    //각 구간에 몇개의 휴게소를 넣을 것인가의 접근 방법을 사용
    //구간에 n개의 휴게소를 넣는다면 (구간의 길이) / (n+1) 이며 나누어 떨어지지 않는다면 +1해준다. 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        memo = new int[N+1][M+1];
        distance = new int[N+1];
        distance[N] = L;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(distance);
        for(int i = N ; i > 0 ; i--){
            distance[i] -= distance[i-1];
        }

        System.out.println(solution(0, M));
    }
    
    /**
     * idx 구간부터 cnt 개의 휴게소를 지을 때 최대 거리의 최소값을 리턴
     * TimeComplex: O(N*M) N<=100 M<=100이므로 가능
     * @param idx: 구간 인덱스
     * @param cnt: 남은 휴게소의 개수
     * @return 휴게소간 최대 거리
     */ 
    private static int solution(int idx, int cnt) {
        if(memo[idx][cnt] != 0)
            return memo[idx][cnt];

        //마지막 구간일 경우
        if(idx == N){
            int val = distance[idx];
            if(cnt != 0) {
                val /= (cnt+1);
                // 구간의 길이가 3이라 가정하고 1개의 휴게소를 짓는다면 최대는 2이므로 (3/2)+1
                if (distance[idx] % (cnt+1) != 0) 
                    val++;
            }
            return memo[idx][cnt] = val;
        }

        memo[idx][cnt] = Integer.MAX_VALUE;
        for (int j = cnt; j >= 0; j--) {
            int val = distance[idx];
            if(j != 0) {
                val /= (j+1);
                if (distance[idx] % (j+1) != 0)
                    val++;
            }

            memo[idx][cnt] = Math.min(memo[idx][cnt], Math.max(val, solution(idx+1, cnt - j)));
        }

        return memo[idx][cnt];
    }
}