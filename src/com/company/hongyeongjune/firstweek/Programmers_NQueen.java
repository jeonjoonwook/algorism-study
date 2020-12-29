package com.company.hongyeongjune.firstweek;

public class Solution {

    static int answer = 0;
    static int[] board = new int[12];

    public int solution(int n) {

        backTracking(0, n);

        return answer;
    }

    public void backTracking(int index, int n) {

        if(index == n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            board[index] = i;
            if(isPossible(index)) {
                backTracking(index+1, n);
            }
        }
    }

    public boolean isPossible(int index) {
        for(int i=0; i<index; i++) {

            if(board[i] == board[index]) return false;
            if(Math.abs(index - i) == Math.abs(board[index] - board[i])) return false;

        }

        return true;
    }
}
