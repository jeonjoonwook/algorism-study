package com.company.geonyeongkim.week9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-02-22
 */
public class LeetCode_139_WordBreak {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(map.get(s) != null) return map.get(s);

        for(int i = 1; i<= s.length(); i++) {
            String sub = s.substring(0, i);
            if(wordDict.contains(sub) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        LeetCode_139_WordBreak wordBreak = new LeetCode_139_WordBreak();
        boolean ans = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("cbca", Arrays.asList("bc","ca"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("ccaccc", Arrays.asList("cc","ac"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("ccaccc", Arrays.asList("cc","ac"));
        System.out.println(ans);

        ans = wordBreak.wordBreak("catskicatcats", Arrays.asList("cats","cat","dog","ski"));
        System.out.println(ans);
    }

}
