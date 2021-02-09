package com.company.hongyeongjune.week7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length() - 10; i++) {
            // 문자열에서 i 부터 i+10 까지 Key 를 검사해서 존재하면 기존 값에 1 을 더한다.
            // 아니라면 0 넣는다.
            if (hashMap.containsKey(s.substring(i, i + 10))) {
                hashMap.put(s.substring(i, i + 10), hashMap.get(s.substring(i, i + 10)) + 1);
            } else hashMap.put(s.substring(i, i + 10), 0);

        }

        // HashMap 의 value 가 0 이상이면 2번 이상 반복이므로
        // 0 이상인 Key 들을 수집하여 return 한다.
        return hashMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}

