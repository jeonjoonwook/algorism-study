package com.company.hongyeongjune.week8.ICT.문제3번;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_시간초과 {

    public static long maxInversions(List<Integer> arr) {

        List<List<Integer>> answer = new ArrayList<>();
        int[] nums = new int[arr.size()];
        for (int i = 0; i < nums.length; i++) nums[i] = arr.get(i);

        int[] value = new int[3];
        for (int i = 0; i < arr.size(); i++) {
            value[0] = arr.get(i);
            dfs(nums, answer, value, i + 1, 1);
        }

        return answer.size();
    }

    public static void dfs(int[] nums,
                           List<List<Integer>> answer,
                           int[] value,
                           int index, int n) {

        if (n == 3) {
            List<Integer> temp = new ArrayList<>();
            for (int v : value) {
                temp.add(v);
            }
            answer.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (value[n - 1] > nums[i]) {
                value[n] = nums[i];
                dfs(nums, answer, value, i + 1, n + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maxInversions(Arrays.asList(
                50,
                615,
                368,
                260,
                115,
                944,
                873,
                353,
                893,
                961,
                333,
                527,
                803,
                474,
                143,
                469,
                555,
                918,
                378,
                147,
                488,
                349,
                899,
                191,
                566,
                695,
                253,
                741,
                191,
                903,
                105,
                363,
                164,
                749,
                835,
                181,
                334,
                212,
                379,
                859,
                358,
                869,
                714,
                318,
                815,
                730,
                501,
                760,
                856,
                411,
                931
        )));
    }

}