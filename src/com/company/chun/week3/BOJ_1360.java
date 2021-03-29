package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//깃처럼 이전 버전을 가지고 있다는 발상을 통해 해결
//초기에는 스택과 큐를 사용해 해결하려 시도했지만 계속 복잡해져만 감
//Time Complex: O(n)
public class Main {
    private final static String TYPE = "type";
    private final static String UNDO = "undo";
    private static State[] states;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        states = new State[N + 1];
        states[0] = new State(0, "");
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals(TYPE)) {
                String c = st.nextToken();
                int sec = Integer.parseInt(st.nextToken());
                states[i] = new State(sec, states[i - 1].string + c);
            } else {
                int to = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());
                states[i] = new State(sec, findPreviousString(sec-to, i));
            }
        }
        System.out.println(states[N].string);
    }

    private static String findPreviousString(int sec, int idx){
        for(int i = idx-1 ; i >= 0 ; i--){
            if(states[i].sec < sec)
                return states[i].string;
        }
        return "";
    }

    static class State {
        int sec;
        String string;

        public State(int sec, String string) {
            this.sec = sec;
            this.string = string;
        }
    }
}