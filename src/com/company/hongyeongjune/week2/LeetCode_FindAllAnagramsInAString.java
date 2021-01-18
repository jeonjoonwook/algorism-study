package com.company.hongyeongjune.week2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> answer = new ArrayList<>();

        int[] nonEmptyString = new int[256];
        for (int i = 0; i < p.length(); i++) {
            nonEmptyString[p.charAt(i)]++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] givenString = new int[256];
            for (int j = i; j < i + p.length(); j++) {
                givenString[s.charAt(j)]++;
            }

            if (check(nonEmptyString, givenString, p)) {
                answer.add(i);
            }
        }
        return answer;
    }

    public static boolean check(int[] nonEmptyString, int[] givenString, String p) {

        for (int i = 0; i < p.length(); i++) {
            if (nonEmptyString[p.charAt(i)] != givenString[p.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
