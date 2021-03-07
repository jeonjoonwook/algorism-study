package com.company.hongyeongjune.week10;

public class Solution {
    public void rotate(int[][] matrix) {

        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {

                // 최종적으로 바뀌어야할 값 저장
                // [0,0] 을 바꾼다고 가정
                // ex) temp = [2,0]
                int temp = matrix[matrix.length - 1 - j][i];
                // 이전 값들의 위치를 찾아서 저장 -> 반복
                // ex) [2,0] <- [2,2]
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                // ex) [2,2] <- [0,2]
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                // ex) [0,2] <- [0,0]
                matrix[j][matrix.length - 1 - i] = matrix[i][j];
                // ex) [0,0] <- temp
                matrix[i][j] = temp;
            }
        }
    }
}
