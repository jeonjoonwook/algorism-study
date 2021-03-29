import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[N+1];
        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            if(src == dest)
                continue;
            list.get(src).add(dest);
            indegree[dest]++;
        }
        List<Integer> answer = topologicalSort(list, indegree);
        for (Integer integer : answer) {
            System.out.print(integer+" ");
        }
    }

    private static List<Integer> topologicalSort(List<List<Integer>> list, int[] indegree){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new LinkedList<>();

        for(int i = 1 ; i < list.size() ; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for (int linked: list.get(node)){
                indegree[linked]--;
                if(indegree[linked] == 0)
                    queue.offer(linked);
            }
        }

        return result;
    }
}