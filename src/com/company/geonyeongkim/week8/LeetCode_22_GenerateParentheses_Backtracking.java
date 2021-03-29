package com.company.geonyeongkim.week8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-02-17
 */
public class LeetCode_22_GenerateParentheses_Backtracking {

    private static List<String> answer;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        dfs("", 0, 0, n);
        return answer;
    }

    private void dfs(String parentheses, int open, int close, int max) {
        if(parentheses.length() == max * 2) {
            answer.add(parentheses);
            return;
        }

        if(open < max) {
            dfs(parentheses + "(", open + 1, close, max);
        }

        if(close < open) {
            dfs(parentheses + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        LeetCode_22_GenerateParentheses_Backtracking generateParentheses = new LeetCode_22_GenerateParentheses_Backtracking();
        List<String> ans = generateParentheses.generateParenthesis(3);
        System.out.println(ans);

        ans = generateParentheses.generateParenthesis(1);
        System.out.println(ans);
    }
}
