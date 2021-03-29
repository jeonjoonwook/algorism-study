package com.company.hongyeongjune.week9;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {


            for (int i = colStart; i <= colEnd; i++)
                answer.add(matrix[rowStart][i]);

            for (int i = rowStart + 1; i <= rowEnd; i++)
                answer.add(matrix[i][colEnd]);

            // 1행이거나 1열일 경우 한번 더 값이 삽입되는 경우가 있어서 조건을 실행
            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i > colStart; i--)
                    answer.add(matrix[rowEnd][i]);

                for (int i = rowEnd; i > rowStart; i--)
                    answer.add(matrix[i][colStart]);
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;

        }

        return answer;
    }
}
