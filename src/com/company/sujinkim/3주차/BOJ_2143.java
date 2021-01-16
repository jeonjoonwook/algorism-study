import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int num, w;
	Node(int num, int w){
		this.num = num;
		this.w = w;
	}
	
	public int compareTo(Node node) {
		return w-node.w;
	}
}

public class Main{
    static int distance[];
	static boolean visit[];
	static LinkedList<Node> list[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		distance = new int[n+1];
		visit = new boolean[n+1];
		list = new LinkedList[n+1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		
		int time[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            dijkstra(i);
            time[i] += distance[x];
        }
        
        dijkstra(x);
        for(int i = 1; i <= n; i++)
            time[i] += distance[i];
        
        int max = 0;
        for(int i = 1; i <= n; i++)
            max = Math.max(max, time[i]);
    
        System.out.println(max);
    }
    
    public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		distance = new int[distance.length];
		visit = new boolean[visit.length];
		Arrays.fill(distance, -1);
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visit[now.num]) {
				visit[now.num] = true;
				for(Node next : list[now.num]) {
					if(distance[next.num] == -1 || distance[next.num] > distance[now.num] + next.w) {
						distance[next.num] = distance[now.num] + next.w;
                        pq.offer(new Node(next.num, distance[next.num]));
					}
				}
			}
		}
	}
}