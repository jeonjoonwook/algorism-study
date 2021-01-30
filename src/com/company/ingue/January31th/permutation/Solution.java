package com.company.ingue.January31th.permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 시간복잡도 : O(n!)
     * 공간복잡도 : O(n!)
     *
     * 재귀를 이용해서 리스트의 원소 하나씩 선택해나가는 방식으로 문제를 풀었습니다.
     *
     * 재귀를 하면서
     * 초기 6 개 --> 5개 --> 4개 ... 0개가 되었을 때 answerList에 add
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();

        addAllPermutation(answerList, getList(nums), new ArrayList<>());

        return answerList;
    }

    private void addAllPermutation(List<List<Integer>> answerList, List<Integer> valueList, List<Integer> answer) {
        if(valueList.size() == 0) {
            answerList.add(answer);

            return;
        }

        for(Integer value : valueList) {
            List<Integer> nextValueList = new ArrayList<>(valueList);
            nextValueList.remove(value);

            List<Integer> nextAnswerList = new ArrayList<>(answer);
            nextAnswerList.add(value);

            addAllPermutation(answerList, nextValueList, nextAnswerList);
        }
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }

        return numList;
    }
}
