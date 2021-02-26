package com.company.hongyeongjune.week9.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

public class 통과_너무오래걸림 {
    public static int lengthOfLongestSubstring(String s) {

        String[] sub = new String[s.length()];

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            sub[i] = new String();
            for (int j = i; j < s.length(); j++) {
                // 중복이 없으면 문자 삽입
                if (sub[i].indexOf(s.charAt(j)) == -1) {
                    sub[i] += s.charAt(j);
                }
                // 중복생기면 멈춤
                else break;
                // 중복 생기기 전까지 길이 계산
                answer = Math.max(answer, sub[i].length());
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("au");
    }
}
