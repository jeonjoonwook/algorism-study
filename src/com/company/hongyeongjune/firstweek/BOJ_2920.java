package com.company.hongyeongjune.firstweek;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scale = new int[8];
        String answer = "";

        for(int i=0; i<8; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<7; i++) {
            if(scale[i] == scale[i+1] - 1) answer = "ascending";
            else if(scale[i] == scale[i+1] + 1) answer = "descending";
            else {
                answer = "mixed";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();

    }
}

