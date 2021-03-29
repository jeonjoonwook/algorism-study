package com.company.hongyeongjune.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력이 있다면 계속 반복
        while(scanner.hasNextInt()) {

            int N = scanner.nextInt();

            // 주가 담는 배열
            int[] stock = new int[N];
            for(int i=0; i<N; i++) {
                stock[i] = scanner.nextInt();
            }

            // 가장 긴 증가하는 부분 수열을 담기 위한 리스트
            List<Integer> answer = new ArrayList<>();
            answer.add(stock[0]);

            for(int i=1; i<N; i++) {
                // 마지막 값 보다 크다면 삽입 -> 오름차순이기 때문에
                if(answer.get(answer.size()-1) < stock[i]) answer.add(stock[i]);
                else {
                    // 가장 작은 값이거나 중간에 낄 수 있는 값이라면
                    // lowerBound -> 이분 탐색을 통해 같거나 큰 값이 처음으로 나오는 index 를 찾는다.
                    // 삽입이 아닌 교체를 한다.
                    // 문제의 예시 5 2 1 4 5 3 을 실행하면
                    // 정답은 1 4 5 이지만 실제 결과는 1 3 5 가 나온다.
                    // 하지만 길이에는 지장이 없으므로 상관없다.
                    answer.set(lowerBound(answer, stock[i]), stock[i]);
                }
            }

            System.out.println(answer.size());
        }
    }

    public static int lowerBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while(left < right) {
            int mid = (left + right) / 2;

            if(list.get(mid) >= target) {
                right = mid;
            }
            else left = mid + 1;
        }

        return right;
    }
}
