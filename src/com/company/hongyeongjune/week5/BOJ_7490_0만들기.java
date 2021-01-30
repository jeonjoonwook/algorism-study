package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static List<String> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());

            answer = new ArrayList<>();

            dfs(N, 2, "1", "1");

            // 출력 형식 떄문에 틀려서 정렬해서 출력함
            answer.sort((o1, o2) -> o1.compareTo(o2));

            for (String a : answer) System.out.println(a);

            System.out.println();

        }
    }

    public static void dfs(int n, int index, String calculate, String expression) {

        // 인덱스를 다 채우면 종료
        if (index == n + 1) {

            // 숫자만 분리
            String[] number = calculate.split("\\+|-");

            // +, - 연산으로만 분리
            Queue<Character> queue = new LinkedList<>();
            for (char c : calculate.toCharArray()) {
                if (c == '+' || c == '-')
                    queue.offer(c);
            }

            // 시작값은 숫자 배열의 첫 번째 값
            int result = Integer.parseInt(number[0]);

            // 계산하기
            for (int i = 1; i < number.length; i++) {
                char operation = queue.poll();
                if (operation == '+') result += Integer.parseInt(number[i]);
                else if (operation == '-') result -= Integer.parseInt(number[i]);
            }

            // 0 이면 answer 리스트에 추가
            if (result == 0) {
                answer.add(expression);
            }
            return;
        }

        dfs(n, index + 1, calculate + "+" + index, expression + "+" + index);
        dfs(n, index + 1, calculate + "-" + index, expression + "-" + index);
        dfs(n, index + 1, calculate + "" + index, expression + " " + index);
    }
}


