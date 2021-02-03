package com.company.hongyeongjune.week6;

public class Solution {
    public boolean isMatch(String s, String p) {
        // 실제 정규표현식에서 '.' 과 '*' 의 능력과 같다.
        return s.matches(p);
    }
}
