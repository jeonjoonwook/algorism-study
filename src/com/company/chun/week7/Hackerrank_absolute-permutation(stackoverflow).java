package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.toString(Solution.absolutePermutation(9331, 0)));
    }
    static int[] absolutePermutation(int n, int k) {
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n];
        if(dfs(answer, visited, 0, k)){
            return answer;
        }
        return new int[]{-1};
    }

    static boolean dfs(int[] answer, boolean[] visited, int idx, int k){
        if(idx == answer.length)
            return true;

        int tmp = Math.min((idx+1) - k, k+(idx+1));
        if(tmp > 0 && !visited[tmp]){
            answer[idx] = tmp;
            visited[tmp] = true;
            if(dfs(answer, visited, idx+1, k))
                return true;
            answer[idx] = 0;
            visited[tmp] = false;
        }

        tmp = Math.max((idx+1) - k, k+(idx+1));;
        if(tmp <= answer.length && !visited[tmp]){
            answer[idx] = tmp;
            visited[tmp] = true;
            if(dfs(answer, visited, idx+1, k))
                return true;
            answer[idx] = 0;
            visited[tmp] = false;
        }
        return false;
    }
}
