package com.company.hongyeongjune.week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> answer = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // 빈공간 있어서 추가
        if (digits.length() == 0) return answer;

        dfs(digits, map, 0, "", answer);

        return answer;
    }

    private void dfs(String digits, Map<Character, String> map, int index, String combinations, List<String> answer) {

        // digits 길이만큼되면 DFS 종료하고 answer 에 추가
        if (index == digits.length()) {
            answer.add(combinations);
            return;
        }

        // 현재 번호의 문자열을 꺼낸다.
        String letters = map.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {
            // 현재 번호의 문자열 중 하나를 담고 다음 번호의 문자열을 알기위해 DFS 진행
            dfs(digits, map, index + 1, combinations + letters.substring(i, i + 1), answer);
        }
    }
}

