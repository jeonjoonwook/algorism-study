package com.company.hongyeongjune.week9.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class 시간초과 {
    public static int lengthOfLongestSubstring(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // 각 subString 의 모든 조합을 검사
                if (withoutRepeatingCharacters(s.substring(i, j))) {
                    answer = Math.max(answer, j - i);
                }
            }
        }

        return 0;
    }

    public static boolean withoutRepeatingCharacters(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            // 중복되면 false
            if (!set.add(c)) return false;
        }
        // 중복없으면 true
        return true;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("au");
    }
}
