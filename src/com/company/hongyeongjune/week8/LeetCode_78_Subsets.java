package com.company.hongyeongjune.week8;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> hashMap = new HashMap<>();
        // 주어진 조건을 확인
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        // Stack 을 통하여 Valid 한지 검사
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // map 에 주어진 문자에 대한 Key 가 존재한다면
            // stack 에 value 를 넣는다.
            if (hashMap.containsKey(s.charAt(i))) {
                stack.push(hashMap.get(s.charAt(i)));
            }
            // map 주어진 문자에 대한 value 가 존재한다면
            else if (hashMap.containsValue(s.charAt(i))) {
                // 빈공간이거나 stack 에서 값을 꺼냈을 때 현재 문자와 일치하지 않다면 false 리턴
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }
        }

        // stack 이 비었는지 아닌지로 valid 함을 검사
        return stack.isEmpty();
    }
}

