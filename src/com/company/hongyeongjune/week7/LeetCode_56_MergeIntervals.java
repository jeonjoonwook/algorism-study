package com.company.hongyeongjune.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {

        List<Point> list = new ArrayList<>();

        // 오름차순 정렬
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 시작 점 뽑기
        Point start = new Point(intervals[0][0], intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // 다음 점 가져오기
            Point next = new Point(intervals[i][0], intervals[i][1]);
            // 시작 점의 y 값과 다음 점의 x 값 중 y 값이 더 크다면
            // 시작 점의 y 값에 다음 값의 y 와 시작점의 y 값을 비교하여 넣어준다.
            if (start.y >= next.x) {
                start.y = Math.max(next.y, start.y);
            } else {
                // 위의 조건이 부합하지 않는다면, List 에 삽입하면 된다.
                list.add(start);
                // 시작점을 다음 점으로 바꿔준다.
                start = next;
            }
        }

        // 마지막 값을 넣기 위해서
        if (!list.contains(start)) list.add(start);

        int[][] answer = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++) {
            answer[i][0] = list.get(i).x;
            answer[i][1] = list.get(i).y;
        }

        return answer;

    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
