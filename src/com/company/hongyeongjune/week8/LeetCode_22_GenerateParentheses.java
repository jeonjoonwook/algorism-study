package com.company.hongyeongjune.week8;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> answer = new ArrayList<>();
        dfs(n, answer, "", 0, 0, 0);

        return answer;
    }

    public void dfs(int n, List<String> answer, String pairs, int left, int right, int length) {

        // String 의 개수가 주어진 N*2 일때까지 재귀
        if (length == n * 2) {
            answer.add(pairs);
            return;
        }

        // "(" 이 개수가 n 보다 작으면 추가
        if (left < n) {
            dfs(n, answer, pairs + "(", left + 1, right, length + 1);
        }
        // ")" 의 개수가 "("의 개수보다 작으면 추가
        if (right < left) {
            dfs(n, answer, pairs + ")", left, right + 1, length + 1);
        }
    }

}

