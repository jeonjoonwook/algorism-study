package com.company.hongyeongjune.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static boolean[][] cabbage;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int worm = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cabbage = new boolean[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbage[x][y] = true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check(i, j)) {
                        worm++;
                        dfs(i, j);
                    }
                }
            }
            answer.add(worm);
        }

        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }

    public static boolean check(int x, int y) {

        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (visited[x][y] || !cabbage[x][y]) return false;
        return true;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if (check(x - 1, y)) dfs(x - 1, y);
        if (check(x + 1, y)) dfs(x + 1, y);
        if (check(x, y - 1)) dfs(x, y - 1);
        if (check(x, y + 1)) dfs(x, y + 1);
    }
}

