import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    // 가장 적은 무게의 가방부터 넣을 수 있는 보석을 찾는다.
    // 그 중 가장 가치가 높은 보석를 매칭한다.
    // O(N + K) 와 O(NlogN) -> 정렬
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

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int jewelryIdx = 0;
        for(int bagIdx =0 ; bagIdx < K ; bagIdx++){
            while(jewelryIdx < N && jewelries.get(jewelryIdx).m <= bag.get(bagIdx)) {
                queue.offer(jewelries.get(jewelryIdx++).v);
            }
            if(!queue.isEmpty())
                answer += queue.poll();
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
            if (this.m > target.m)
                return 1;
            else
                return -1;
        }
    }
}