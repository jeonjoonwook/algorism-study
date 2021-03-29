package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사대
        int M = Integer.parseInt(st.nextToken());
        // 동물
        int N = Integer.parseInt(st.nextToken());
        // 범위
        int L = Integer.parseInt(st.nextToken());

        int[] firingPoint = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            firingPoint[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색 사용을 위한 정렬
        Arrays.sort(firingPoint);

        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new Animal(x, y));
        }

        int answer = 0;
        // 각 동물에 대해서 한 사대의 범위안에만 들면 되기때문에 동물의 개수로 반복문을 시작
        for(int i=0; i<N; i++) {

            // 사대 개수
            int left = 0;
            int right = M;

            while(left < right) {

                int mid = (left + right) / 2;
                // 이분 탐색으로 사대[mid] 값의 거리를 잰다.
                int distance = getDistance(firingPoint[mid], animals.get(i).x, animals.get(i).y);

                // 범위안에 들지 않았고, 사대보다 오른쪽에 있다면 left 값을 올린다
                if(L < distance && firingPoint[mid] < animals.get(i).x) {
                    left = mid + 1;
                }
                // 범위안에 들지 않았고, 사대보다 왼쪽에 있다면 right 값을 낮춘다.
                else if(L < distance && firingPoint[mid] >= animals.get(i).x) {
                    right = mid;
                }
                // 범위 안에 들면 종료.
                else if(L >= distance) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static int getDistance(int firingPoint, int x, int y) {
        return Math.abs(firingPoint - x) + y;
    }

    public static class Animal {
        int x;
        int y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}