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

        int[][] node = new int[computer + 1][computer + 1];
        boolean[] visited = new boolean[computer + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = node[y][x] = 1;
        }

        dfs(1, node, visited);
        System.out.println(answer);
    }

    private static void dfs(int start, int[][] node, boolean[] visited) {

        visited[start] = true;

        for (int i = 0; i < node.length; i++) {
            if (node[start][i] == 1 && !visited[i]) {
                dfs(i, node, visited);
                answer++;
            }
        }
    }

}

