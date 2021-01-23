package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Long> answer = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        long[] solution = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }

        // 이분 탐색을 사용하기 위해 오름차순 정렬
        Arrays.sort(solution);

        for (int i = 0; i < N - 2; i++) {
            // 현재 인덱스의 값 오른쪽 값부터 이분탐색으로 찾는다.
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                // 세 용액의 합
                // 현재 인덱스 + 이분탐색으로 찾는 왼쪽값 , 오른쪽값
                long sum = solution[i] + solution[left] + solution[right];

                // 절대값 비교
                if (Math.abs(sum) < MAX) {
                    answer.clear();
                    answer.add(solution[i]);
                    answer.add(solution[left]);
                    answer.add(solution[right]);
                    MAX = Math.abs(sum);
                }

                // 세 용액의 합이 0 보다 크다면 값을 낮추기 위해 오른쪽 인덱스를 하나 낮춘다.
                if (sum > 0) right--;
                    // 세 용액의 합이 0 이하이면 값을 올리기 위해 왼쪽 인덱스를 하나 높힌다.
                else left++;
            }
        }

        answer.stream().sorted().forEach(a -> System.out.print(a + " "));
    }
}
