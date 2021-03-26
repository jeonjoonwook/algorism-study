package com.company.hongyeongjune.week12;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (memo.containsKey(arr[i] - difference)) {
                memo.put(arr[i], memo.get(arr[i] - difference) + 1);
            } else memo.put(arr[i], 1);

        }

        int answer = 0;
        for (int key : memo.keySet()) {
            answer = Math.max(answer, memo.get(key));
        }

        return answer;
    }

}
