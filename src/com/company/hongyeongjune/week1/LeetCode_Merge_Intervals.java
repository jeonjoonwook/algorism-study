package com.company.hongyeongjune.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {

        List<Element> result = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        Element before = new Element(intervals[0][0], intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            Element now = new Element(intervals[i][0], intervals[i][1]);
            if (before.end >= now.start) {
                before.end = Math.max(before.end, now.end);
            } else {
                result.add(before);
                before = now;
            }
        }

        if (!result.contains(before)) result.add(before);

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = result.get(i).start;
            answer[i][1] = result.get(i).end;
        }

        return answer;
    }

    public static class Element {
        private int start;
        private int end;

        public Element(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}