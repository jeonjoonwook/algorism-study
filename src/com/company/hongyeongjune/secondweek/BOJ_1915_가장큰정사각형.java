package com.company.hongyeongjune.secondweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int answer = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                // board 의 값이 0 이라면 정사각형을 만들 수 없다.
                if (board[i][j] == 0) continue;
                // board[i][j]를 기준으로 왼쪽 위쪽 대각선 방향중 최솟값을 찾는다.
                // board[i][j]를 기준으로 정사각형을 만들 때,
                // 각 방향에서 최솟값을 기준으로 1 더하면 최대로 만들 수 있는 정사각형의 길이가 된다.
                board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1])) + 1;
                answer = Math.max(board[i][j], answer);
            }
        }

        // 주어진 board 가 1행 이거나 1열일 경우는 위의 공식이 의미가 없다.
        // 따라서 1행 이거나 1열일 경우 1이 하나라도 존재하면 answer = 1이 된다.
        if (answer == 0) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == 1) answer = 1;
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 1) answer = 1;
            }
        }

        System.out.println(answer * answer);
    }
}