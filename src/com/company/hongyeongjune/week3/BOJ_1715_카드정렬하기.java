package com.company.hongyeongjune.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int first = pq.poll();
            if (pq.isEmpty()) break;
            int second = pq.poll();
            pq.offer(first + second);
            answer += (first + second);
        }

        System.out.println(answer);
    }

}
