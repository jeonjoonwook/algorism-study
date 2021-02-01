package com.company.hongyeongjune.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //상하좌우로 움직이기 위한 배열
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};

    public static int[][] cheese;
    public static boolean[][] visited;
    public static int row;
    public static int column;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        cheese = new int[row][column];
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<column; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        // 판에 녹을 수 있는 치즈가 남아있는동안 반복
        while(isMelt()) {
            // 한번 실행할 때마다 1시간씩 늘리기
            hour++;
            // 방문 초기화
            visited = new boolean[row][column];
            // 녹은 치즈 개수 초기화
            count = 0;
            // dfs 시작
            dfs(1,1);
        }

        System.out.println(hour);
        System.out.println(count);

    }

    // 녹을 수 있는 치즈가 있는지 검사
    public static boolean isMelt() {

        // '2' 상태는 치즈를 녹이라는 상태
        // 녹여서 '0' 으로 만들어준다.
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(cheese[i][j] == 2) cheese[i][j] = 0;
            }
        }

        // '1' 상태는 치즈가 녹을 수 있는 상태
        // '1' 이 존재하면 true 를 리턴
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(cheese[i][j] == 1) return true;
            }
        }

        // 녹을 수 있는 치즈가 없으므로 false 리턴
        return false;
    }

    public static void dfs(int x, int y) {

        for(int i=0; i<4; i++) {
            // 상하좌우 이동
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 상화좌우 이동 좌표가 치즈 판 범위 안에 있고, 방문하지 않았다면
            if(newX >= 0 && newY >= 0 && newX < row && newY < column
                    && !visited[newX][newY]) {
                // 방문 처리
                visited[newX][newY] = true;

                // 치즈가 녹을 수 있다면
                // 녹여야하는 상태 '2' 로 만들어주고
                // 녹일 치즈 개수를 센다.
                // 공기중에 맞닿는 치즈만 녹여야하므로 1인 치즈를 만나면 녹이는 상태로 만들어주고 더이상 DFS 를 실행하지 않는다.
                if(cheese[newX][newY] == 1) {
                    cheese[newX][newY] = 2;
                    count++;
                }
                // 위의 모든 조건에 해당하지 않는다면 DFS 실행
                else dfs(newX, newY);

            }
        }
    }
}

