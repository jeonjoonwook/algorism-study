package graph;

//πÈ¡ÿ 1260 dfsøÕ bfs

import java.util.*;

public class dfsAndBfs {
	
	static int[][] connect = new int[1001][1001];
	static boolean[] visitedDfs;
	static boolean[] visitedBfs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pointCnt = sc.nextInt();
		int connectCnt = sc.nextInt();
		int startPoint = sc.nextInt();
		
		for(int i=0; i<connectCnt; i++)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			connect[m][n]=1;
			connect[n][m]=1;
		}
		
		visitedDfs = new boolean[pointCnt+1];
		visitedBfs = new boolean[pointCnt+1];
		
		dfs(startPoint);
		System.out.println();
		bfs(startPoint);
	}
	
	public static void dfs(int point)
	{
		visitedDfs[point] = true;
		System.out.print(point + " ");
		
		for(int i=1; i<visitedDfs.length; i++)
		{
			if(connect[i][point]==1 && visitedDfs[i]==false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int point)
	{
		visitedBfs[point]=true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(point);
		System.out.print(point + " ");
		
		while(!queue.isEmpty())
		{
			int poll = queue.poll();
			
			for(int i=1; i<visitedBfs.length; i++)
			{
				if(connect[point][i]==1 && visitedBfs[i]==false)
				{
					visitedBfs[i]=true;
					queue.offer(i);
					System.out.print(i+ " ");
				}
			}
			
		}
		
	}
	

}
