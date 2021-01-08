package com.company.hongyeongjune.secondweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int INF = Integer.MAX_VALUE;
    public static List<List<Node>> graph;
    public static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance = new int[n + 1];
            Arrays.fill(distance, INF);

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, s));
            }

            dijkstra(c);
            int node = 0;
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (distance[i] != INF) {
                    node++;
                    answer = Math.max(answer, distance[i]);
                }
            }
            System.out.println(node + " " + answer);
        }
    }

    public static void dijkstra(int start) {

        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.offer(new Node(start, distance[start]));

        while (!pq.isEmpty()) {

            int current = pq.peek().node;
            int currentDistance = pq.peek().distance;
            pq.poll();

            if (distance[current] < currentDistance) continue;

            for (int i = 0; i < graph.get(current).size(); i++) {

                int next = graph.get(current).get(i).node;
                int nextDistance = currentDistance + graph.get(current).get(i).distance;

                if (nextDistance < distance[next]) {
                    distance[next] = nextDistance;
                    pq.offer(new Node(next, nextDistance));
                }

            }

        }
    }

    public static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
