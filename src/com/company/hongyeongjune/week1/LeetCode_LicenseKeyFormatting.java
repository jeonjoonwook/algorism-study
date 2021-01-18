package com.company.hongyeongjune.week1;

import java.util.Stack;

public class Solution {
    public static String licenseKeyFormatting(String S, int K) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '-') stack.push(c);
        }

        int length = 0;
        String answer = "";

        while (!stack.isEmpty()) {

            if (length == K) {
                answer += "-";
                length = 0;
            }

            answer += stack.pop();
            length++;
        }
        StringBuilder stringBuilder = new StringBuilder(answer.toUpperCase());

        return stringBuilder.reverse().toString();
    }
}
