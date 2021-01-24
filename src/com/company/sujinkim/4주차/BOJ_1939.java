import java.io.*;
import java.util.*;

public class Main {
    static class Bridge{
		int to;
		int weight;

		public Bridge(){}

		public Bridge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}

	}
    
	static int max_weight = 0;
	static ArrayList<ArrayList<Bridge>> bridges = new ArrayList<>();
	static int start, finish;

	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer strtok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(strtok.nextToken());
		int M = Integer.parseInt(strtok.nextToken());

		for(int i = 0; i <= N; i++){
            bridges.add(new ArrayList<>());   
        }
		for(int i = 0; i < M; i++){
			strtok = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strtok.nextToken());
			int b = Integer.parseInt(strtok.nextToken());
			int c = Integer.parseInt(strtok.nextToken());

			bridges.get(a).add(new Bridge(b, c));
			bridges.get(b).add(new Bridge(a, c));
			max_weight = Math.max(max_weight, c);
		}

		strtok = new StringTokenizer(br.readLine());

		start = Integer.parseInt(strtok.nextToken());
		finish = Integer.parseInt(strtok.nextToken());

		bw.write(binarySearch(N)+"");
		bw.close();
	}

	//1 ~ max_weight 까지 이분탐색
	private static int binarySearch(int N){
		int left = 1;
		int right = max_weight;
		int max = 0;

		while(left <= right){
			int mid = (left + right) / 2;

			if(bfs(N, mid)){
				max = Math.max(max, mid);
				left = mid + 1;
			}else
				right = mid - 1;
		}
		return max;
	}

	//weight : 현재 트럭의 무게
	private static boolean bfs(int N, int weight){
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[N+1];

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()){
			int now = queue.poll();

			if(now == finish)
				return true;

			for(int i = 0;i < bridges.get(now).size();i++){
				Bridge bridge = bridges.get(now).get(i);

				int next = bridge.to;
				int limit = bridge.weight;

				if(!visited[next] && weight <= limit){
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		return false;
	}

}