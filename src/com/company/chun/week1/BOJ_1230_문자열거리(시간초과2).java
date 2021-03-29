package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] memo;
    private static String src, dest;
    private final static int MAX_VAL = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        src = br.readLine();
        dest = br.readLine();
        if(src.length() > dest.length()){
            System.out.println(-1);
            return;
        }

        memo = new int[src.length()][dest.length()];
        int answer = MAX_VAL;
        if(src.charAt(0) == dest.charAt(0))
            answer = solution(0, 0);
        for(int i = 0 ; i < dest.length() ; i++){
            if(src.charAt(0) != dest.charAt(i))
                continue;
            answer = Math.min(answer, solution(0, i) + 1);
        }

        if(answer >= MAX_VAL)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    // srcIdx의 문자가 destIdx의 문자일 때 삽입 횟수.
    // 삽입을 해도 못만들어지면 Integer.MAX 를 리턴
    private static int solution(int srcIdx, int destIdx){
        if(srcIdx == src.length()-1 && destIdx == dest.length()-1)
            return 0;
        if(srcIdx == src.length()-1)
            return 1;
        if(destIdx == dest.length()-1)
            return MAX_VAL;

        if(memo[srcIdx][destIdx] != 0)
            return memo[srcIdx][destIdx];

        int nextSrcIdx = srcIdx+1;
        memo[srcIdx][destIdx] = MAX_VAL;
        for(int k = destIdx+1 ; k < dest.length() ; k++){
            if(dest.charAt(k) != src.charAt(nextSrcIdx))
                continue;
            if(destIdx+1 == k)
                memo[srcIdx][destIdx] = Math.min(memo[srcIdx][destIdx], solution(nextSrcIdx, k));
            memo[srcIdx][destIdx] = Math.min(memo[srcIdx][destIdx], solution(nextSrcIdx, k) + 1);
        }
        return memo[srcIdx][destIdx];
    }
}