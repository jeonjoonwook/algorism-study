package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1 ; j <= m ; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        int answer = 0;
        for(int r = 1 ; r <= n ; r++){
            for(int c = 1 ; c <= m ; c++){
                if(map[r][c] == 0)
                    continue;
                map[r][c] = Math.min(map[r-1][c], Math.min(map[r-1][c-1], map[r][c-1])) + 1;
                answer = Math.max(answer, map[r][c]);
            }
        }
        System.out.println(answer * answer);
    }
}