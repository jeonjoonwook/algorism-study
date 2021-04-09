package graph;

import java.util.*;


//백준 1012 유기농 배추
public class FreshCabbage {
	static int m,n,k;
	static int[][] cabbage;
	static boolean[][] visited;
	static int result=0;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int t = scan.nextInt();
		
		for(int i=0; i<t; i++)
		{
			result=0;
			m = scan.nextInt();
			n = scan.nextInt();
			k = scan.nextInt();
			
			cabbage = new int[n][m];
			visited = new boolean[n][m];
			
			for(int j=0; j<k; j++)
			{
				int x = scan.nextInt();
				int y = scan.nextInt();
				cabbage[y][x] = 1;
			}
			
			for(int a=0; a<n; a++)
			{
				for(int b=0; b<m; b++)
				{
					if(cabbage[a][b]==1 && !visited[a][b])
					{
						dfs(a,b);
						result++;
					}	
				}
			}
			System.out.println(result);
		}
		
	}
	
	static void dfs(int y, int x)
	{
		visited[y][x] = true;
		
		for(int i=0; i<4; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && ny<n && nx>=0 && nx<m)
			{
				if(!visited[ny][nx] && cabbage[ny][nx]==1)
				{
					dfs(ny,nx);
				}
			}
		}
	}

}
