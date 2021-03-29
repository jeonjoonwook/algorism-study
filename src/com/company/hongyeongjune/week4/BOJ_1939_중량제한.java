package com.company.hongyeongjune.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] parent;
    public static List<Node> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 부모를 자기자신으로 설정
        parent = new int[N + 1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        graph = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 높은 무게부터 정하기 위해 내림차순으로 정렬
        graph.sort((o1, o2) -> o2.weight - o1.weight);

        for(int i=0; i<graph.size(); i++) {
            Node node = graph.get(i);
            // 같은 부모인지 확인 -> 부모가 다르다면
            if(!findParent(parent, node.start, node.end)) {
                // 부모가 다르다면 부모 합치기 -> 같은 부모를 갖게된다.
                unionParent(parent, node.start, node.end);
            }
            // 부모 찾기 -> 부모가 같다면 즉, 연결이 되었다면 시작도시에서 끝도시의 가장 큰 값을 구한다.
            if(findParent(parent, start, end)) {
                answer = node.weight;
                break;
            }
        }

        System.out.println(answer);
    }

    // 부모 값 가져오기
    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return true;
        else return false;
    }

    public static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }
}
