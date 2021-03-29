package com.company.ingue.January31th.ValidSudoku;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 시간복잡도 : O(n^2)
     * 공간복잡도 : O(n^2)
     *
     * 가로 세로 검증 후에
     *
     * 3x3 검증
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (!isValidRowAndColumn(board)) {
            return false;
        }

        if (!isValidBox(board)) {
            return false;
        }

        return true;
    }

    private boolean isValidRowAndColumn(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            List<Integer> rowList = getRowList(board, i);
            List<Integer> columnList = getColumnList(board, i);

            if (!isValidList(rowList)) {
                return false;
            }

            if (!isValidList(columnList)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidList(List<Integer> rowList) {
        boolean[] checkList = new boolean[10];

        for (int value : rowList) {
            if (checkList[value]) {
                return false;
            }

            checkList[value] = true;
        }

        return true;
    }

    private List<Integer> getColumnList(char[][] board, int column) {
        List<Integer> columnList = new ArrayList<>();

        for (int i = 0; i < board[column].length; i++) {
            if (Character.isDigit(board[i][column])) {
                columnList.add(Character.getNumericValue(board[i][column]));
            }
        }

        return columnList;
    }

    private List<Integer> getRowList(char[][] board, int row) {
        List<Integer> rowList = new ArrayList<>();

        for (int i = 0; i < board[row].length; i++) {
            if (Character.isDigit(board[row][i])) {
                rowList.add(Character.getNumericValue(board[row][i]));
            }
        }

        return rowList;
    }

    private List<Integer> getBoxList(char[][] board, int row, int column) {
        List<Integer> boxList = new ArrayList<>();

        for (int i = row * 3; i < row * 3 + 3; i++) {
            for (int j = column * 3; j < column * 3 + 3; j++) {
                if (Character.isDigit(board[i][j])) {
                    boxList.add(Character.getNumericValue(board[i][j]));
                }
            }
        }

        return boxList;
    }

    private boolean isValidBox(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Integer> boxList = getBoxList(board, i, j);

                if (!isValidList(boxList)) {
                    return false;
                }
            }
        }

        return true;
    }
}
