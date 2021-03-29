package com.company.geonyeongkim.week6;

import java.util.Set;
import java.util.Stack;

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s) {
        Set<Character> open = Set.of('(', '{', '[');
        Set<Character> close = Set.of(')', '}', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(open.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if(close.contains(s.charAt(i))) {
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        LeetCode_20_ValidParentheses validParentheses = new LeetCode_20_ValidParentheses();
        boolean ans = validParentheses.isValid("()");
        System.out.println(ans);

        ans = validParentheses.isValid("()[]{}");
        System.out.println(ans);

        ans = validParentheses.isValid("(]");
        System.out.println(ans);

        ans = validParentheses.isValid("([)]");
        System.out.println(ans);

        ans = validParentheses.isValid("{[]}");
        System.out.println(ans);

        ans = validParentheses.isValid("]");
        System.out.println(ans);

        ans = validParentheses.isValid("(])");
        System.out.println(ans);
    }
}
