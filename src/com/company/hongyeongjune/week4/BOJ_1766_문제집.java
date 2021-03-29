package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            inDegree[y]++;
        }

        topologySort(graph, inDegree);
    }

    private static void topologySort(List<List<Integer>> graph, int[] inDegree) {

        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입 차수가 0 이면 큐에 삽입
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();
            // 우선순위 큐에 있는 값을 꺼내 담기
            answer.add(node);
            for (int i = 0; i < graph.get(node).size(); i++) {
                // 현재 노드와 연결된 다음 노드 찾기
                int next = graph.get(node).get(i);
                // 차수 줄이기
                inDegree[next]--;
                // 차수가 0 이면 큐에 삽입
                if (inDegree[next] == 0) pq.offer(next);
            }
        }

        answer.stream().forEach(s -> System.out.print(s + " "));
    }

}
