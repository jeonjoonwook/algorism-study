package com.company.hongyeongjune.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static HashMap<String, Integer> hashMap;
    public static int index;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int F = Integer.parseInt(br.readLine());
            // UnionFind 를 사용하기 위한 부모 배열
            int[] parent = new int[F * 2];
            // 친구 관계의 수를 저장하기 위한 배열
            int[] relation = new int[F * 2];

            // 항상 두명 씩 친구 관계가 있기 때문에 최대 길이는 F*2
            for (int i = 0; i < F * 2; i++) {
                // 초기 부모를 인덱스로 설정
                parent[i] = i;
                // 자기 자신은 무조건 있으므로 1을 넣어줌
                relation[i] = 1;
            }

            hashMap = new HashMap<>();
            // 각 친구들을 숫자로 표기하기 위해 사용
            index = 0;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = getHashMapValue(st.nextToken());
                int b = getHashMapValue(st.nextToken());

                System.out.println(unionParent(parent, relation, a, b));
            }

        }
    }

    // 각 친구들의 번호를 가져온다.
    private static int getHashMapValue(String name) {
        if (!hashMap.containsKey(name)) {
            hashMap.put(name, index++);
            return hashMap.get(name);
        }
        return hashMap.get(name);
    }

    // 부모 찾기
    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 부모를 합치면서 친구의 관계까지 더해서 return 한다.
    private static int unionParent(int[] parent, int[] relation, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
            relation[a] += relation[b];
            return relation[a];
        } else {
            parent[a] = b;
            relation[b] += relation[a];
            return relation[b];
        }
    }
}