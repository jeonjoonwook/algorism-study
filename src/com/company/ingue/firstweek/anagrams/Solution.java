package com.company.ingue.firstweek.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramsList = new ArrayList<>();

        if(s.length() < p.length()) {
            return anagramsList;
        }

        Map<Character, Integer> pCountMap = initMap(p);
        Map<Character, Integer> sCountMap = initMap(s.substring(0, p.length()));

        if (pCountMap.equals(sCountMap)) {
            anagramsList.add(0);
        }

        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            char left = s.charAt(i-1);
            char right = s.charAt(i + p.length() - 1);

            removeValue(sCountMap, left);
            addValue(sCountMap, right);

            if (pCountMap.equals(sCountMap)) {
                anagramsList.add(i);
            }
        }

        return anagramsList;
    }

    private void addValue(Map<Character, Integer> sCountMap, char right) {
        if (sCountMap.containsKey(right)) {
            sCountMap.put(right, sCountMap.get(right) + 1);
        }

        sCountMap.putIfAbsent(right, 1);
    }

    private void removeValue(Map<Character, Integer> sCountMap, char left) {
        if (sCountMap.get(left) == 1) {
            sCountMap.remove(left);
        } else {
            sCountMap.put(left, sCountMap.get(left) - 1);
        }
    }

    private Map<Character, Integer> initMap(String input) {
        Map<Character, Integer> inputCountMap = new HashMap<>();
        char[] pArray = input.toCharArray();

        for (int i = 0; i < pArray.length; i++) {
            addValue(inputCountMap, pArray[i]);
        }

        return inputCountMap;
    }
}
