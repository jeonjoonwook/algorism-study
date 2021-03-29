package com.company.hongyeongjune.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            /**
             * strs 배열안의 str 값은 순서와 상관없이 같은 문자이면 되기 때문에 정렬된 str 값을 key 로 등록
             */
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            if (hashMap.containsKey(key))
                hashMap.get(key).add(str);
            else {
                List<String> init = new ArrayList<>();
                init.add(str);
                hashMap.put(key, init);
            }
        }
        //hashMap 의 모든 값을 List 에 담는다.
        answer.addAll(hashMap.values());

        return answer;
    }
}

