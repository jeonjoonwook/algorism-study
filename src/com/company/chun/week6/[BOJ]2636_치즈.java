package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final static int HOLE = 0;
    final static int CHEESE = 1;
    final static int AIR = 2;
    static int[][] map;
    static int N, M, lastCheeseCount;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int r = 0 ; r < N ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(!isClear()){
            day++;
            markAir();
            removeCheeseOneDay();
        }
        System.out.println(day+"\n"+lastCheeseCount);
    }

    private static void removeCheeseOneDay() {
        List<Pair> list = new ArrayList<>();
        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < M ; c++){
                if(map[r][c] != CHEESE){
                    continue;
                }
                for(int i = 0 ; i < dy.length ; i++){
                    int y = r + dy[i];
                    int x = c + dx[i];
                    if(check(y, x)){
                        list.add(new Pair(r, c));
                        break;
                    }
                }
            }
        }
        for(Pair p : list){
            map[p.y][p.x] = AIR;
        }
    }

    private static boolean check(int y, int x) {
        return y >= 0 && y < N
                && x >= 0 && x < M
                && map[y][x] == AIR;
    }

    private static void markAir() {
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            for(int i = 0 ; i < dy.length ; i++){
                int y = poll.y + dy[i];
                int x = poll.x + dx[i];
                if(check(y, x, visited)){
                    visited[y][x] = true;
                    map[y][x] = AIR;
                    queue.offer(new Pair(y, x));
                }
            }
        }
    }

    private static boolean check(int y, int x, boolean[][] visited) {
        return y >= 0 && y < N
                && x >= 0 && x < M
                && (map[y][x] == HOLE || map[y][x] == AIR)
                && !visited[y][x]
                ;
    }

    private static boolean isClear() {
        int count = 0;
        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < M ; c++){
                if(map[r][c] == CHEESE)
                    count++;
            }
        }

        if(count == 0)
            return true;
        
        lastCheeseCount = count;
        return false;
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}