package com.company.hongyeongjune.week5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTracking(candidates, target, answer, list, 0, 0);

        return answer;
    }

    public void backTracking(int[] candidates, int target,
                             List<List<Integer>> answer, List<Integer> list,
                             int sum, int index) {

        // sum 이 더 크게되면 조건을 만족못하므로 종료
        if (target < sum) return;
        // answer 에 추가
        if (target == sum) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 리스트에 담기
            list.add(candidates[i]);
            // 백트래킹 실행
            backTracking(candidates, target, answer, list, sum + candidates[i], i);
            // 조건이 충족되지 않으면 마지막 원소 제거
            list.remove(list.size() - 1);
        }
    }
}
