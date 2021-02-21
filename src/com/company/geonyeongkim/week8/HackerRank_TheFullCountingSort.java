package com.company.geonyeongkim.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRank_TheFullCountingSort {

    static void countSort(List<List<String>> arr) {
        StringBuilder[] answer = new StringBuilder[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = new StringBuilder();
        }

        int half = arr.size() / 2;

        for(int i = 0; i < arr.size(); i++) {
            int idx = Integer.parseInt(arr.get(i).get(0));
            if(i < half) {
                answer[idx].append("- ");
            } else {
                answer[idx].append(arr.get(i).get(1)).append(" ");
            }
        }

        for (StringBuilder sb: answer) {
            System.out.print(sb.toString());
        }
    }

    public static void main(String[] args) {
        List<List<String>> q1 = new ArrayList<>();
        q1.add(Arrays.asList("0", "ab"));
        q1.add(Arrays.asList("6", "cd"));
        q1.add(Arrays.asList("0", "ef"));
        q1.add(Arrays.asList("6", "gh"));
        q1.add(Arrays.asList("4", "ij"));
        q1.add(Arrays.asList("0", "ab"));
        q1.add(Arrays.asList("6", "cd"));
        q1.add(Arrays.asList("0", "ef"));
        q1.add(Arrays.asList("6", "gh"));
        q1.add(Arrays.asList("0", "ij"));
        q1.add(Arrays.asList("4", "that"));
        q1.add(Arrays.asList("3", "be"));
        q1.add(Arrays.asList("0", "to"));
        q1.add(Arrays.asList("1", "be"));
        q1.add(Arrays.asList("5", "question"));
        q1.add(Arrays.asList("1", "or"));
        q1.add(Arrays.asList("2", "not"));
        q1.add(Arrays.asList("4", "is"));
        q1.add(Arrays.asList("2", "to"));
        q1.add(Arrays.asList("4", "the"));

        HackerRank_TheFullCountingSort.countSort(q1);
        System.out.println();

        List<List<String>> q2 = new ArrayList<>();
        q2.add(Arrays.asList("1", "e"));
        q2.add(Arrays.asList("2", "a"));
        q2.add(Arrays.asList("1", "b"));
        q2.add(Arrays.asList("3", "a"));
        q2.add(Arrays.asList("4", "f"));
        q2.add(Arrays.asList("1", "f"));
        q2.add(Arrays.asList("2", "a"));
        q2.add(Arrays.asList("1", "e"));
        q2.add(Arrays.asList("1", "b"));
        q2.add(Arrays.asList("1", "c"));
        HackerRank_TheFullCountingSort.countSort(q2);
    }
}
