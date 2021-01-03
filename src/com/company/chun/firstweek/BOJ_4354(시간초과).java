package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 문자열의 반복되는 가장긴 문자열 찾기
    // 문자열 길이가 백만개이므로 nlogn까지 가능
    // 나누어 떨어지는 수만 계산

    private static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            s = br.readLine();
            if(s.equals(".")) {
                break;
            }
            int answer = 0;
            for(int len = 1 ; len < s.length() / 2 ; len++){
                if(s.length() % len != 0)
                    continue;
                if(isRepetitive(len)){
                    answer =s.length()/len;
                    break;
                }
            }
            if(answer == 0)
                sb.append(1).append('\n');
            else
                sb.append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static boolean isRepetitive(int length){
        for(int i = 0 ; i < length ; i++){
            for(int j = i + length ; j < s.length() ; j+=length){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}