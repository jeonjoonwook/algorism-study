package com.company.hongyeongjune.week11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] gems) {

        Set<String> set = new HashSet<>();
        for (String gem : gems) set.add(gem);

        Map<String, Integer> map = new HashMap<>();

        int index = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < gems.length; i++) {

            if (!map.containsKey(gems[i])) map.put(gems[i], 1);
            else map.put(gems[i], map.get(gems[i]) + 1);

            if (map.size() == set.size()) {
                while (map.get(gems[index]) > 1) {
                    map.put(gems[index], map.get(gems[index]) - 1);
                    index++;
                }
            }

            if (map.size() == set.size() && min > i - index) {
                min = i - index;
                start = index;
                end = index + min;
            }


        }

        return new int[]{start, end};
    }
}

