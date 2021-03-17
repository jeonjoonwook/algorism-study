package com.company.hongyeongjune.week12;

import java.util.*;

public class Solution {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i=0; i<info.length; i++) {
            dfs(info[i].split(" "), 0, "", map);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
            map.put(key,map.get(key));
        }

        for(int i=0; i<query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] s = split[3].split(" ");
            String value = split[0] + split[1] + split[2] + s[0];

            for(String key : map.keySet()) {
                if(!value.equals(key)) continue;

                int index = lowerBound(map.get(key), Integer.parseInt(s[1]));
                answer[i] = map.get(key).size() - index;
            }
        }

        return answer;
    }

    public void dfs(String[] info, int index, String result, Map<String, List<Integer>> map) {

        if(index == 4) {
            if(!map.containsKey(result)) map.put(result, new ArrayList<>(Arrays.asList(Integer.parseInt(info[4]))));
            else {
                List<Integer> temp = map.get(result);
                temp.add(Integer.parseInt(info[4]));
                map.put(result, temp);
            }
            return;
        }

        dfs(info, index+1, result+"-", map);
        dfs(info, index+1, result + info[index], map);
    }

    public int lowerBound(List<Integer> data, int target) {
        int left = 0;

        int right = data.size();

        while(left < right) {
            int mid = (left + right) / 2;

            if(data.get(mid) >= target) right = mid;
            else left = mid + 1;

        }

        return right;
    }
}
