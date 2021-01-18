package com.company;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{5,6,7},{9,10,11},{12, 13, 14}}));
        System.out.println(s.spiralOrder(new int[][]{{1}}));
    }
    private int[][] map;
    public List<Integer> spiralOrder(int[][] matrix) {
        map = matrix;
        return solution(0, 0, matrix.length-1, matrix[0].length-1);
    }

    //재귀를 사용하여 해결함.
    //가장 테두리부터 돌고, 테두리 안에 정보는 재귀를 통해서
    private List<Integer> solution(int y1, int x1, int y2, int x2){
        if(y1 > y2 || x1 > x2) //매트릭스 내에 모든 요소 탐색이 완료된 경우
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(int i = x1 ; i <= x2 ; i++){//상단
            list.add(map[y1][i]);
        }
        for(int i = y1+1 ; i <= y2 ; i++){//오른쪽
            list.add(map[i][x2]);
        }
        //같다면 할 필요가 없다.
        if(y1 != y2) {
            for (int i = x2-1; i > x1 ; i--){//하단
                list.add(map[y2][i]);
            }
        }
        if(x1 != x2){//왼쪽
            for(int i = y2 ; i > y1 ; i--){
                list.add(map[i][x1]);
            }
        }

        //현재 테두리는 탐색을 완료했고 내부또한 재귀돌려 넣은뒤 반환.
        list.addAll(solution(y1+1, x1+1, y2-1, x2-1));
        return list;
    }
}