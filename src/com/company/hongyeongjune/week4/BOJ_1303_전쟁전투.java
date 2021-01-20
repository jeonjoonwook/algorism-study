package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int M;
    public static char[][] war;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        war = new char[M][N];
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] soldier = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (soldier[j].equals("W"))
                    war[i][j] = 'W';
                else war[i][j] = 'B';
            }
        }

        int W = 0;
        int B = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int answer = dfs(i, j, visited, war[i][j]);
                    if (war[i][j] == 'W') W += (answer * answer);
                    else B += (answer * answer);
                }
            }
        }

        System.out.println(W + " " + B);
    }

    private static int dfs(int x, int y, boolean[][] visited, char soldier) {

        int count = 1;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < M && newY >= 0 && newY < N
                    && war[newX][newY] == soldier && !visited[newX][newY]) {
                count += dfs(newX, newY, visited, soldier);
            }
        }

        return count;
    }
}
