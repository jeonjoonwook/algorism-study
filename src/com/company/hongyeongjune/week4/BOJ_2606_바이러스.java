package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 컴퓨터의 연관을 보여주는 배열
        int[][] node = new int[computer + 1][computer + 1];
        // 방문 목록
        boolean[] visited = new boolean[computer + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향으로 연결
            node[x][y] = node[y][x] = 1;
        }

        dfs(1, node, visited);
        System.out.println(answer);
    }

    private static void dfs(int start, int[][] node, boolean[] visited) {

        visited[start] = true;

        for (int i = 0; i < node.length; i++) {
            // 방문하지 않았고, 서로 연결되어 있다면 answer 의 값을 하나 늘린다.
            if (node[start][i] == 1 && !visited[i]) {
                dfs(i, node, visited);
                answer++;
            }
        }
    }

}

