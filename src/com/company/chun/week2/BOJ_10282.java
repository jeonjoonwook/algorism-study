import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int MAX_VAL = 10000001;
    static int V;
    static List<List<Node>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map = new ArrayList<>();
            for(int i = 0 ; i <= V ; i++){
                map.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                map.get(b).add(new Node(a, s));
            }
            int[] distance = dijkstra(c);
            int cnt = 0, max = 0;
            for (int v : distance) {
                if (v != MAX_VAL) {
                    cnt++;
                    max = Math.max(max, v);
                }
            }
            System.out.println(cnt + " " + max);
        }
    }

    private static int[] dijkstra(int res){
        int[] distance = new int[V+1]; //최소 거리 저장
        boolean[] visited = new boolean[V+1]; //방문 여부 저장
        Arrays.fill(distance, MAX_VAL);
        //출발지에서 각 노드들 간 연결된 거리 초기화
        for (Node node : map.get(res)) {
            distance[node.d] = node.w;
        }

        visited[res] = true;
        // n-1번 돌리면 된다.
        for(int i = 0 ; i < V-1 ; i++){
            int minIdx = res;
            int minVal = MAX_VAL;
            //방문하지 않은 노드 중 거리가 가장 짧은 노드 찾는다.
            for(int j = 1 ; j < distance.length ; j++){
                if(!visited[j] && minVal > distance[j]){
                    minIdx = j;
                    minVal = distance[j];
                }
            }

            visited[minIdx] = true;
            //선택된 노드와 연결된 노드들 중 자신까지의 거리와 선택된 노드를 거친 거리를 비교
            for(Node node : map.get(minIdx)){
                if(distance[node.d] > node.w + distance[minIdx]){
                    distance[node.d] = node.w + distance[minIdx];
                }
            }
        }
        distance[res] = 0;
        return distance;
    }

    private static class Node {
        int d, w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}