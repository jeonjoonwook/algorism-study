package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로 이동을 쉽게하기 위한 배열
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

        // W, B 담기
        for (int i = 0; i < M; i++) {
            String[] soldier = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (soldier[j].equals("W"))
                    war[i][j] = 'W';
                else war[i][j] = 'B';
            }
        }

        // W 와 B의 병사의 위력
        int W = 0;
        int B = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았다면 DFS 실행
                if (!visited[i][j]) {
                    // 서로 인접한 병사들의 수
                    int answer = dfs(i, j, visited, war[i][j]);
                    // W 병사 B 병사 따로 계산
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
            //dx[i] , dy[i] 의 값
            // {-1 , 0}  -> 왼쪽으로 한칸
            // {1 , 0} -> 오른쪽으로 한칸
            // {0 , -1} -> 아래쪽으로 한칸
            // {0 , 1} -> 위쪽으로 한칸
            int newX = x + dx[i];
            int newY = y + dy[i];
            // 범위안에 있고
            // 같은 병사이고, 방문하지 않았다면 개수 늘리기
            if (newX >= 0 && newX < M && newY >= 0 && newY < N
                    && war[newX][newY] == soldier && !visited[newX][newY]) {
                count += dfs(newX, newY, visited, soldier);
            }
        }

        return count;
    }
}
