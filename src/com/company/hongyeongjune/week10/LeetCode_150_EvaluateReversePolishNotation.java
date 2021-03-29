package com.company.hongyeongjune.week10;

import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int first, second;

        for (int i = 0; i < tokens.length; i++) {
            if (isParseInt(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                second = stack.pop();
                first = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static boolean isParseInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
