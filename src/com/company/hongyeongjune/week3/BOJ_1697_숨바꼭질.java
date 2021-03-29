package com.company.hongyeongjune.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 몇 초인지 기억하기 위한 배열
        int[] time = new int[100001];

        if (N > K) {
            System.out.println(N - K);
            return;
        }

        // 방문하지 않은 값들 초기화
        Arrays.fill(time, -1);
        System.out.println(bfs(N, K, time));

    }

    public static int bfs(int n, int k, int[] time) {

        // 시작
        int start = n;

        // -1, +1, *2 를 저장하기 위한 배열
        int[] move = new int[3];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // 시작하는 위치의 초
        time[start] = 0;

        while (!queue.isEmpty()) {

            // 시작하는 위치의 값
            int current = queue.poll();

            // 각 이동 값
            move[0] = current - 1;
            move[1] = current + 1;
            move[2] = current * 2;

            // 각 이동 값이 0, 100000 사이에 있고, 방문하지 않았다면
            for (int i = 0; i < 3; i++) {
                if (0 <= move[i] && move[i] <= 100000 && time[move[i]] == -1) {
                    // 큐에 넣기
                    queue.offer(move[i]);
                    // 이동한 위치에 현재초에 + 1 하기
                    time[move[i]] = time[current] + 1;
                }
            }
        }

        return time[k];
    }


}