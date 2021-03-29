package com.company.hongyeongjune.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int start;
    private static int[][] edge;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        edge = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x][y] = edge[y][x] = 1;
        }

        dfs(start, visited);
        System.out.println("");
        bfs();

    }

    private static void dfs(int start, boolean[] visited) {

        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if (edge[start][i] == 1 && !visited[i])
                dfs(i, visited);
        }

    }

    private static void bfs() {

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            System.out.print(temp + " ");

            for (int i = 1; i <= N; i++) {
                if (edge[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
