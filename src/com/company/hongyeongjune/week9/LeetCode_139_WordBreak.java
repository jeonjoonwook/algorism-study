package com.company.hongyeongjune.week9;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {

        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    System.out.println(i + " , " + j + " , " + s.substring(i, j));
                    if (wordDict.contains(s.substring(i, j))) {
                        dp[j] = i;
                    }
                }
            }
        }

        if (dp[dp.length - 1] != -1) return true;

        return false;
    }
}
