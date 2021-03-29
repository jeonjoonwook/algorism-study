package dynamic;

import java.util.*;

//백준 1915 가장 큰 정사각형
public class MaxSquare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] map = new int[1001][1001];
		int[][] dp = new int[1001][1001];
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int result=0;
		
		for(int i=0; i<x; i++)
		{
			String line = scan.next();
			for(int j=0; j<y; j++)
			{
				map[i][j]= line.charAt(j)-'0';
				dp[i][j]=1;
				result=1;
			}
		}
		
		for(int i=1; i<x; i++) {
			for(int j=1; j<y; j++)
			{
				if(map[i-1][j]==1 && map[i-1][j-1]==1 && map[i][j-1]==1)
				{
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1])+1;
				}
				result = Math.max(dp[i][j], result);
			}
		}
		
		System.out.println(result*result);

	}

}
