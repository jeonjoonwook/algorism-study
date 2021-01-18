package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MAX_VAL = 100001;
    private static boolean[] visited; //같은 연산 반복을 막긴 위해
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX_VAL];
        Queue<Integer> queue = new LinkedList<>(); //BFS를 사용하기 위한 큐
        queue.offer(N);
        int time = 0; // 시간을 위한 변수
        boolean flag = false;
        while(!queue.isEmpty()){
            //queue 내에 있는 값들은 같은 시간에 있을 수 있는 위치를 의미한다.
            //size 만큼만 반복문을 돌려야 다음 시간 위치와 혼동이 없다.
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int poll = queue.poll();
                if (poll == K) {
                    flag = true;
                    break;
                }
                
                //다음 시간의 값들을 넣어줌
                int v1 = poll * 2;
                int v2 = poll + 1;
                int v3 = poll - 1;
                if(check(v1)) {
                    queue.offer(v1);
                    visited[v1] = true;
                }
                if(check(v2)) {
                    queue.offer(v2);
                    visited[v2] = true;
                }
                if(check(v3)) {
                    queue.offer(v3);
                    visited[v3] = true;
                }
            }
            if(flag)
                break;
            time++;
        }

        System.out.println(time);
    }
    
    private static boolean check(int n){
        return n >= 0 && n < MAX_VAL && !visited[n];
    }
}