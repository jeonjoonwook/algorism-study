package com.company.hongyeongjune.week5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {

       List<List<Integer>> answer = new ArrayList<>();
       int[] value = new int[nums.length];
       boolean[] visited = new boolean[nums.length];

       dfs(nums, answer, value, visited, 0);

        return answer;
    }

    public void dfs(int[] nums,
                    List<List<Integer>> answer,
                    int[] value,
                    boolean[] visited, int n) {

        // 인덱스가 nums 의 인덱스와 같아진다면 차례대로 List 에 담아 answer 리스트에 넣어준다.
        if(n == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int v : value) temp.add(v);
            answer.add(temp);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            // 방문하지 않았다면
            if(!visited[i]) {
                // 방문되지 않은 값을 value 배열에 넣어주고 방문처리
                visited[i] = true;
                value[n] = nums[i];
                // 다시 DFS 로 방문되지 않은 값을 찾는다. -> 인덱스를 하나 늘려준다.
                dfs(nums, answer, value, visited, n+1);
                visited[i] = false;
            }
        }
    }
}
