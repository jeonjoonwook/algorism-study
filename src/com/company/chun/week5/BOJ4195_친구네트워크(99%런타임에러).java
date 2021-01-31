package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, F;
    static Map<String, Set<String>> networkMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            F = Integer.parseInt(br.readLine());
            networkMap = new HashMap<>();
            StringBuilder answer = new StringBuilder();
            while(F-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                networkMap.computeIfAbsent(f1, s -> new HashSet<>());
                networkMap.computeIfAbsent(f2, s -> new HashSet<>());
                makeFriends(f1, f2);
                answer.append(networkMap.get(f1).size()+1).append("\n");
            }
            System.out.print(answer.toString());
        }
    }

    private static void makeFriends(String f1, String f2){
        for(String s : networkMap.get(f1)){
            networkMap.get(s).addAll(networkMap.get(f2));
            networkMap.get(s).add(f2);
        }

        for(String s : networkMap.get(f2)){
            networkMap.get(s).addAll(networkMap.get(f1));
            networkMap.get(s).add(f1);
        }

        networkMap.get(f1).add(f2);
        networkMap.get(f1).addAll(networkMap.get(f2));
        networkMap.get(f2).add(f1);

        for(String s : networkMap.get(f1)){
            if(s.equals(f2))
                continue;
            networkMap.get(f2).add(s);
        }
    }
}