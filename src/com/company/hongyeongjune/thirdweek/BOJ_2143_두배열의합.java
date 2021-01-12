package com.company.hongyeongjune.thirdweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * A 배열의 부분합을 구하고 오름차순 정렬
         * 부분 합 : O(n^2)
         * 정렬 : O(nlogn)
         */
        List<Integer> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }
        sumA.sort((o1, o2) -> o1 - o2);

        /**
         * B 배열의 부분합을 구하고 오름차순 정렬
         * 부분 합 : O(n^2)
         * 정렬 : O(nlogn)
         */
        List<Integer> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }
        sumB.sort((o1, o2) -> o1 - o2);

        /**
         * A의 부분합 + B의 부분합 = T
         *  => B = T - A 로 변환
         * answer += upperBound(List, target) - lowerBound(List, target)
         *  => upperBound : target 값 보다 큰 값의 위치
         *  => lowerBound : target 값이랑 같거나 큰 값의 위치
         *  -> 해당 값이 없다면 upperBound - lowerBound 는 둘다 똑같이 target 값보다 큰 값을 찾게되므로 0이 나오게된다.
         *  -> 해당 값이 존재한다면 upperBound 는 해당 값보다 큰 값의 위치를 return , lowerBound는 같은 값의 위치를 return
         *     즉, List 안에 target 값이 몇개 있는지 알 수 있다.
         * answer 를 Long 타입으로 선언한 이유
         *  => A 배열의 최대 크기 : 1000
         *  => B 배열의 최대 크기 : 1000
         *  => A 배열의 부분 합 최대 개수 : 500,500
         *  => B 배열의 부분 합 최대 개수 : 500,500
         *  A, B 배열의 모든 값이 0 이라면 -> answer 는 500,500 * 500,500 개 -> ㅑint 의 최대 값을 훨씬 초과하는 값
         */
        long answer = 0;
        for (int i = 0; i < sumA.size(); i++) {
            int target = T - sumA.get(i);
            answer += upperBound(sumB, target) - lowerBound(sumB, target);
        }

        System.out.println(answer);
    }

    /**
     * 데이터 안에 특정 값보다 큰 값이 처음 나오는 값의 Index
     *
     * @param list   : List
     * @param target : 찾으려는 값
     * @return
     */
    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target)
                left = mid + 1;
            else right = mid;
        }

        return right;
    }

    /**
     * 데이터 안에 특정 값이랑 같거나 큰 값이 처음 나오는 값의 Index
     *
     * @param list   : List
     * @param target : 찾으려는 값
     * @return
     */
    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target)
                right = mid;
            else left = mid + 1;
        }

        return right;
    }
}

