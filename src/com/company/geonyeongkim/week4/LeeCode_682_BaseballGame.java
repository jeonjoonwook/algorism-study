package com.company.geonyeongkim.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-23
 */
public class LeeCode_682_BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();

        for (String op : ops) {

            try {
                int opNum = Integer.parseInt(op);
                list.add(opNum);
            } catch (NumberFormatException e) {
                if ("+".equals(op)) {
                    list.add(list.get(list.size() -1) + list.get(list.size() -2));
                } else if ("D".equals(op)) {
                    list.add(list.get(list.size() -1) * 2);
                } else {
                    list.remove(list.size()-1);
                }
            }

        }

        int answer = 0;
        for (Integer score : list) {
            answer += score;
        }
        return answer;
    }
}
