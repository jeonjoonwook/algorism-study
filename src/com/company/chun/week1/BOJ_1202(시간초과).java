package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    // 가장 가치가 높은 보석을 가장 가방 무게가 작은 가방부터 검사하며 넣는다.
    // O(N*K)의 시간복잡도.. 시간초과..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Jewelry> jewelries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        jewelries.sort(Jewelry::compareTo);

        List<Integer> bag = new ArrayList<>();
        for(int i = 0; i < K; i++){
            bag.add(Integer.parseInt(br.readLine()));
        }
        bag.sort(Comparator.naturalOrder());

        boolean[] visited = new boolean[K];
        int cnt = 0, answer = 0;
        for(int j = 0 ; j < N ; j++){
            if(cnt == K)
                break;

            for(int i = 0 ; i < K ; i++){
                if(visited[i] && jewelries.get(j).m < bag.get(i)){
                    continue;
                }
                answer+= jewelries.get(j).v;
                visited[i] = true;
                cnt++;
                break;
            }
        }
        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int m;
        int v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry target) {
            if (this.v > target.v)
                return -1;
            else
                return 1;
        }
    }
}