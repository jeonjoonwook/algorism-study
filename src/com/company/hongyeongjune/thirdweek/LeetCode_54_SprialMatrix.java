package com.company.hongyeongjune.thirdweek;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            // 오른쪽으로 모든 값을 채워나간다.
            for (int i = colStart; i <= colEnd; i++)
                answer.add(matrix[rowStart][i]);

            //아래쪽으로 모든 값을 채워나간다.
            for (int i = rowStart + 1; i <= rowEnd; i++)
                answer.add(matrix[i][colEnd]);

            //1행이거나 1열일 경우 값이 한번 더 삽입되는 경우가 생긴다.
            //따라서 조건을 실행
            if (rowStart < rowEnd && colStart < colEnd) {

                //왼쪽으로 모든 값을 채우기
                for (int i = colEnd - 1; i > colStart; i--)
                    answer.add(matrix[rowEnd][i]);

                //위쪽으로 모든 값을 채우기
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