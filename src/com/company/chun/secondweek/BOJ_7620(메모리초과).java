package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String src, dest;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        src = br.readLine();
        dest = br.readLine();


        distance = new int[src.length() + 1][dest.length() + 1];
        for (int i = 1; i <= src.length(); i++) {
            distance[i][0] = i;
        }

        for (int i = 1; i <= dest.length(); i++) {
            distance[0][i] = i;
        }

        for (int r = 1; r <= src.length(); r++) {
            for (int c = 1; c <= dest.length(); c++) {
                if (src.charAt(r - 1) == dest.charAt(c - 1)) {
                    distance[r][c] = distance[r - 1][c - 1];
                    continue;
                }
                distance[r][c] = Math.min(distance[r - 1][c]
                        , Math.min(distance[r - 1][c - 1], distance[r][c - 1])) + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int r = src.length(), c = dest.length();
        while (r > 0 && c > 0) {
            int val = Math.min(distance[r - 1][c], Math.min(distance[r - 1][c - 1], distance[r][c - 1]));
            if (val == distance[r][c]) {
                sb.append(dest.charAt(c - 1)).append(" c").append("\n");
                r--;
                c--;
                continue;
            }

            if (val == distance[r - 1][c]) {
                sb.append(src.charAt(r - 1)).append(" d").append("\n");
                r--;
            } else if (val == distance[r - 1][c - 1]) {
                sb.append(dest.charAt(c - 1)).append(" m").append("\n");
                r--;
                c--;
            } else {
                sb.append(dest.charAt(c - 1)).append(" a").append("\n");
                c--;
            }
        }

        if (r != 0) {
            while (r > 0) {
                sb.append(src.charAt(r - 1)).append(" d").append("\n");
                r--;
            }
        } else if (c != 0) {
            while (c > 0) {
                sb.append(dest.charAt(c - 1)).append(" a").append("\n");
                c--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}