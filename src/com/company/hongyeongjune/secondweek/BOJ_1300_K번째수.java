package com.company.hongyeongjune.secondweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1;
        // 오름차순으로 정렬된 배열 B의 K번째 수를 찾기
        // 최댓값이 N*N이 아닌 이유
        // -> K번 째 해당하는 수는 절대 K를 초과하지 않는다.
        // -> 배열 A에 중복된 값이 두 개씩 존재하기 때문
        long right = K;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                // i번째 행은 i의 배수이다.
                // 임의의 mid 값보다 작은 i번째 행의 개수 => mid/i
                // mid/i가 N보다 크다면 무조건 N -> 배열의 크기는 최대 N이기 때문
                // mid 보다 작은 값들의 개수를 센다.
                count += Math.min(mid / i, N);
            }

            // mid 보다 작은 값들의 개수가 K 보다 크다면
            // -> mid 값 이하에서 문제를 구하려는 답이 있다.
            // -> answer = mid 를 해주고 더 작은 범위에서 찾아야하므로 right = mid - 1을 한다.
            if (count >= K) {
                answer = mid;
                right = mid - 1;
            }
            // mid 보다 작은 값들의 개수가 K 보다 작다면
            // -> 더 큰 범위에서 찾아야하므로 left = mid + 1 을 한다.
            else left = mid + 1;
        }

        System.out.println(answer);
    }
}
