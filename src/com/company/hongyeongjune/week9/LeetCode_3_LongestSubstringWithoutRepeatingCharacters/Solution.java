package com.company.hongyeongjune.week9.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int answer = 0;
        int left = 0;
        int right = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();

        // 투포인터 알고리즘으로 생각
        while (left <= right && right < s.length()) {
            // 문자 중복이 안되면
            if (!map.containsKey(s.charAt(right))) {
                // 길이 늘리기
                length++;
                // map 에 넣기
                map.put(s.charAt(right), 1);
                // right 값 늘리기
                right++;
            }
            // 중복이 되면
            else {
                // 시작 값의 인덱스가 빠지기 때문에 길이도 1 빼주기
                length--;
                // map 에 값 삭제
                map.remove(s.charAt(left));
                // left 값 늘리기
                left++;
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }
}

