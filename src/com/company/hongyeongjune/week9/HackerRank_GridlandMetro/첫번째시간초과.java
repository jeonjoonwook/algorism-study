package com.company.hongyeongjune.week9.HackerRank_GridlandMetro;

import java.util.HashMap;
import java.util.Map;

public class Solution_시간초과_첫번째 {

    static int gridlandMetro(int n, int m, int k, int[][] track) {

        int answer = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<track.length; i++) {
            if(map.containsKey(track[i][0])) {
                Map<Integer, Integer> temp = map.get(track[i][0]);
                for(int j=track[i][1]; j<=track[i][2]; j++) temp.put(j, 1);
                map.put(track[i][0], temp);
            }
            else {
                Map<Integer, Integer> temp = new HashMap<>();
                for(int j=track[i][1]; j<=track[i][2]; j++) temp.put(j, 1);
                map.put(track[i][0], temp);
            }
        }

        for(int key : map.keySet()) {
            answer += map.get(key).entrySet().stream().filter(entry -> entry.getValue() == 1).count();
        }

        return m*n - answer;

    }

}

