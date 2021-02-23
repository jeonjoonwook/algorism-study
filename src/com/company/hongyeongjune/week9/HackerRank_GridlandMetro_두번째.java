package com.company.hongyeongjune.week9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution_시간초과_두번째 {

    static int gridlandMetro(int n, int m, int k, int[][] track) {

        long answer = (long)m*(long)n;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i=0; i<track.length; i++) {
            if(map.containsKey(track[i][0])) {
                HashSet<Integer> set = map.get(track[i][0]);
                for(int j=track[i][1]; j<=track[i][2]; j++) if(set.add(j)) answer--;
                map.put(track[i][0], set);
            }
            else {
                HashSet<Integer> set = new HashSet<>();
                for(int j=track[i][1]; j<=track[i][2]; j++) if(set.add(j)) answer--;
                map.put(track[i][0], set);
            }
        }

        return (int) answer;

    }

}
