package com.company.hongyeongjune.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] blackJack = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            blackJack[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        combination(blackJack, visited, 0, N, 3);

        answer.sort((o1, o2) -> o2 - o1);

        bw.write(answer.get(0) + "");
        bw.flush();
        bw.close();

    }

    private static void combination(int[] blackJack, boolean[] visited, int start, int n, int length) {

        if(length == 0) {
            int temp = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]) temp += blackJack[i];
            }
            if(temp <= M) answer.add(temp);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(blackJack, visited, i+1, n, length - 1);
            visited[i] = false;
        }

    }
}
