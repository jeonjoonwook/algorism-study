package com.company.hongyeongjune.week9;

public class Solution {
    public String longestPalindrome(String s) {

        // 하나만 있을 경우 그대로 리턴
        if (s.length() <= 1) return s;

        int[] index = new int[2];

        // 자기 자신을 기준으로 왼쪽 오른쪽으로 팰린드롬 시전
        // 짝수, 홀수의 경우가 있기 때문에
        // 홀수일경우 자기 자신을 기준
        // 짝수일경우 자기자신, 자기자신+1 을 기준
        for (int i = 0; i < s.length() - 1; i++) {
            findPalindrome(s, i, i, index);
            findPalindrome(s, i, i + 1, index);
        }


        return s.substring(index[0], index[0] + index[1]);
    }

    private void findPalindrome(String s, int left, int right, int[] index) {

        // 자기자신을 기준으로 자신포함 양옆으로 벌려나가면서 비교
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 현재 저장된 값보다 더 큰길이가 나타나면 조건문 실행
        if (index[1] < right - left - 1) {
            index[0] = left + 1;
            index[1] = right - left - 1;
        }
    }
}

