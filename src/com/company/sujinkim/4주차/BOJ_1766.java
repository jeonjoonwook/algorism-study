import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[n+1];
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++){
			list[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 1; i < n+1; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			int temp = q.remove();
			System.out.println(temp);
            
			for(int i = 0; i < list[temp].size(); i++){
				int cur = list[temp].get(i);
				indegree[cur]--;
				
				if(indegree[cur]==0){
					q.add(cur);
				}
			}
		}
        
	}

}