package com.company.hongyeongjune.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<List<Node>> graph;
    public static int[][] dp;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        /**
         * 다익스트라를 이용해 값을 계속해서 갱신해야하기 때문에
         * 처음에 연결이 직접적으로 되지 않았다는 표시를 구분하기 위해
         * Integer.MAX_VALUE 로 값을 채워준다.
         */
        dp = new int[N + 1][N + 1];
        for (int[] d : dp)
            Arrays.fill(d, INF);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            /**
             * Graph 에서 start 와 연결된 모든 노드와 비용을 알기 위함.
             */
            graph.get(start).add(new Node(end, time));
        }

        /**
         * 특정 마을로 참석하고 돌아와야하기 때문에 각자 마을(노드) 기준에서 최단거리를 알아야한다.
         * 따라서 다익스트라를 각자 마을 마다 실행
         */
        for (int i = 1; i < dp.length; i++) {
            dijkstra(i, i);
        }

        /**
         * 최단거리를 다 구한 상태에서 제일 오래 걸리는 값을 찾는다.
         */
        for (int i = 1; i < dp.length; i++) {
            answer = Math.max(answer, dp[i][X] + dp[X][i]);
        }

        System.out.println(answer);
    }

    public static void dijkstra(int start, int index) {

        dp[index][start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.offer(new Node(start, dp[index][start]));

        while (!pq.isEmpty()) {

            int current = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            if (dp[index][current] < distance) continue;

            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i).node;
                int nextDistance = distance + graph.get(current).get(i).distance;

                if (nextDistance < dp[index][next]) {
                    dp[index][next] = nextDistance;
                    pq.offer(new Node(next, nextDistance));
                }
            }
        }

    }

    /**
     * node : 연결된 값
     * distance : 비용
     */
    public static class Node {
        private int node;
        private int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}

