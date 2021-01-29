package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사대
        int M = Integer.parseInt(st.nextToken());
        // 동물
        int N = Integer.parseInt(st.nextToken());
        // 거리
        int L = Integer.parseInt(st.nextToken());

        int[] firingPoint = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            firingPoint[i] = Integer.parseInt(st.nextToken());
        }

        List<Animal> animals = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new Animal(x,y));
        }
        // 시간을 줄이기 위한 방문 처리
        boolean[] visited = new boolean[animals.size()];

        // 동물의 수 만큼 반복
        for(int i=0; i<N; i++) {
            search(animals, firingPoint, visited, i, L);
        }

        System.out.println(answer);
    }

    public static void search(List<Animal> animals, int[] firingPoint, boolean[] visited, int index, int range) {

        // 한 동물이 사대의 범위에 맞는지 확인
        for(int i=0; i<firingPoint.length; i++) {
            int distance = getDistance(firingPoint[i], animals.get(index).x, animals.get(index).y);
            // 이미 방문했다면 멈춤
            if(visited[index]) break;
            // 아직 방문을 하지 않았고, 범위 안에 있다면 방문처리를 해주고 break;
            if(!visited[index] && range >= distance) {
                visited[index] = true;
                answer++;
                break;
            }
        }
    }

    // 사대의 범위 계산
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
