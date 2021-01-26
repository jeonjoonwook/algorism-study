package com.company.hongyeongjune.week5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row.add(board[i][j] - '0');
                }
                if (board[j][i] != '.') {
                    column.add(board[j][i] - '0');
                }
            }
            // 행에서 중복된 숫자가 있다면
            if (row.stream().distinct().count() != row.size()) return false;
            // 열에서 중복된 숫자가 있다면
            if (column.stream().distinct().count() != column.size()) return false;
            row.clear();
            column.clear();
        }

        // 기준
        for (int k = 0; k < 9; k++) {
            // 기준 값을 통해 반복
            for (int i = (k / 3) * 3; i < (k / 3 * 3) + 3; i++) {
                for (int j = (k % 3) * 3; j < (k % 3 * 3) + 3; j++) {
                    if (board[i][j] != '.') {
                        box.add(board[i][j] - '0');
                    }
                }
            }
            // 한 박스 안에 중복된 숫자가 있다면면
            if (box.stream().distinct().count() != box.size()) return false;
            box.clear();
        }

        return true;
    }

}

