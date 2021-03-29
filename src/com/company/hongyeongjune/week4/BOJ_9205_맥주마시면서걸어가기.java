package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            //x, y좌표 담기
            List<Point> points = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            // 건널수있는 판단하는 배열
            boolean[][] dp = new boolean[n + 2][n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points.add(new Point(x, y));
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    // 건널 수 있는 확인
                    if (interval(points.get(i), points.get(j)) <= 1000) {
                        dp[i][j] = dp[j][i] = true;
                    }
                }
            }

            // k : 거쳐가는 지점
            for (int k = 0; k < n + 2; k++) {
                // i : 출발 지점
                for (int i = 0; i < n + 2; i++) {
                    // j : 도착 지점
                    for (int j = 0; j < n + 2; j++) {
                        //i 에서 출발하여 k를 거쳐 j에 갈 수 있다면
                        if (dp[i][k] && dp[k][j]) dp[i][j] = true;
                    }
                }
            }

            if (dp[0][n + 1]) System.out.println("happy");
            else System.out.println("sad");
        }

    }

    public static int interval(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
