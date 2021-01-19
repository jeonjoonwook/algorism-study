package com.company.hongyeongjune.week4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> answer = new ArrayList<>();

        for (String op : ops) {

            // "C" 일 때, List 의 마지막 값 제거
            if (op.equals("C")) {
                answer.remove(answer.size() - 1);
            }

            // "D" 일 떄, List 의 마지막 값에서 * 2 한 값을 추가
            else if (op.equals("D")) {
                answer.add(answer.get(answer.size() - 1) * 2);
            }

            // "+" 일 때, List 의 마지막 값과 마지막보다 하나 작은 인덱스의 값 더하고 List 에 추가
            else if (op.equals("+")) {
                answer.add(answer.get(answer.size() - 1) + answer.get(answer.size() - 2));
            }

            // 숫자 일 때, 리스트에 추가
            else {
                answer.add(Integer.parseInt(op));
            }
        }

        // 리스트의 모든 값을 더해서 return 하기
        return answer.stream().reduce(0, Integer::sum);
    }
}

