package com.company.hongyeongjune.week6;

import java.util.Arrays;

public class Solution {

    public static int answer;

    public static int coinChange(int[] coins, int amount) {

        // 최솟값을 비교하기 위한 MAX 설정
        answer = Integer.MAX_VALUE;

        // 정렬이 안된 값들도 있어서 정렬했음.
        Arrays.sort(coins);

        // DFS 시작
        // coins, amount, 코인의 가장 큰 값의 인덱스, 코인 사용 횟수
        dfs(coins, amount, coins.length-1, 0);

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;

    }

    public static void dfs(int[] coins, int amount, int index, int count) {

        // 코인의 인덱스가 0 아래로 내려가면 더 이상 진행할 수 없으므로 끝낸다.
        if(index < 0) return;

        // amount/coins[index] 부터 0 까지 반복한다
        // 가장 큰 코인부터 나눠서 반복해야한다 -> 시간 단축을 위해
        for(int i=amount/coins[index]; i>=0; i--) {

            // Amount 에서 가장 큰 코인부터 차례대로 사용할 수 있는 개수 만큼 빼준다.
            int change = amount - (i*coins[index]);
            // 현재 사용한 누적 코인의 개수
            int accumulate = count + i;

            // Amount 가 0 이 되면 결과 값을 만들 수 있으므로 answer 를 비교한다.
            if(change == 0) {
                answer = Math.min(answer, accumulate);
                return;
            }
            // 원래 이 코드는 없었는데 시간초과가 떠서 추가했다.
            // 누적 코인 횟수가 answer 보다 커지면 더 이상 dfs 를 진행하지 않고 종료한다.
            if(accumulate >= answer) return;

            // coins, amount 에서 코인을 사용할 수 있는 횟수를 빼준 값, 코인의 인덱스를 낮춘 값, 코인 사용 누적 횟수
            dfs(coins, change, index-1, accumulate);
        }
    }
}
