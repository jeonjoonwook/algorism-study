package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        long[] prime = new long[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            prime[i] = Long.parseLong(st.nextToken());
            // 현재 입력된 소수들을 우선순위 큐에 넣는다.
            pq.offer(prime[i]);
        }

        long answer = 0;
        // N 번째 수를 찾기 때문에 N번 만큼 반복
        for(int i=0; i<N; i++) {
            // 우선 순위 큐에 있는 값을 하나 꺼낸다.
            answer = pq.poll();
            for(int j=0; j<K; j++) {
                // 큐에서 꺼낸 값에 prime 배열에 담긴 소수들을 곱하면 소수의 곱을 구할 수 있다.
                pq.offer(answer * prime[j]);
                // 소수의 곱을 하면 중복이 생길 수 있다.
                // 중복을 없애기 위해 answer 에 담은 큐의 값이 이미 prime 배열안의 값으로 나누어 떨어진다면 반복문을 종료한다.
                if(answer % prime[j] == 0) break;
            }
        }

        System.out.println(answer);
    }
}