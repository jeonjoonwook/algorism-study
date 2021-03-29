package com.company.hongyeongjune.week6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        int[] value = new int[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, answer, value, visited, 0);

        return answer;
    }

    public void dfs(int[] nums, List<List<Integer>> answer, int[] value, boolean[] visited, int index) {

        if(index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int v : value) temp.add(v);
            // 포함되지 않았다면 추가
            if(!answer.contains(temp)) answer.add(temp);

            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                value[index] = nums[i];
                dfs(nums, answer, value, visited, index+1);
                visited[i] = false;
            }
        }
    }
}

