package com.company.geonyeongkim.week5;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansewr = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            subList.add(candidates[i]);
            dfs(candidates, target, ansewr, subList, i);
            subList.remove(subList.size() -1);
        }

        return ansewr;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ansewr, List<Integer> subList, int start) {

        int sum = 0;
        for (int num : subList) {
            sum += num;
        }

        if(sum > target) return;
        if(sum == target) {
            ansewr.add(new ArrayList<>(subList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            subList.add(candidates[i]);
            dfs(candidates, target, ansewr, subList, i);
            subList.remove(subList.size() -1);
        }
    }

    public static void main(String[] args) {
        LeetCode_39_Combination_Sum combinationSum = new LeetCode_39_Combination_Sum();
        List<List<Integer>> ans = combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(ans);

        ans = combinationSum.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(ans);

        ans = combinationSum.combinationSum(new int[]{2}, 1);
        System.out.println(ans);

        ans = combinationSum.combinationSum(new int[]{1}, 1);
        System.out.println(ans);

        ans = combinationSum.combinationSum(new int[]{1}, 2);
        System.out.println(ans);
    }
}
