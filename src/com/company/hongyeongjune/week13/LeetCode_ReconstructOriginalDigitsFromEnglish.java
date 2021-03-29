package com.company.hongyeongjune.week13;

import java.util.Arrays;

public class Solution {
    public String originalDigits(String s) {

        StringBuilder sb = new StringBuilder();

        char[] digits = s.toCharArray();
        int[] count = new int[26];

        for (char digit : digits) {
            count[digit - 'a']++;
        }

        originalDigits(count, 'z', "zero", "0", sb);
        originalDigits(count, 'w', "two", "2", sb);
        originalDigits(count, 'u', "four", "4", sb);
        originalDigits(count, 'x', "six", "6", sb);
        originalDigits(count, 'g', "eight", "8", sb);

        originalDigits(count, 'o', "one", "1", sb);
        originalDigits(count, 't', "three", "3", sb);
        originalDigits(count, 'f', "five", "5", sb);
        originalDigits(count, 's', "seven", "7", sb);

        originalDigits(count, 'i', "nine", "9", sb);

        char[] sorting = sb.toString().toCharArray();

        Arrays.sort(sorting);

        String answer = "";
        for (char c : sorting)
            answer += c;

        return answer;
    }

    public void originalDigits(int[] count, char unique, String digits, String number, StringBuilder sb) {

        while (count[unique - 'a'] != 0) {
            for (char digit : digits.toCharArray()) {
                count[digit - 'a']--;
            }
            sb.append(number);
        }
    }
}
