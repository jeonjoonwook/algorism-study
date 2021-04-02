package algorithm_java_string_array_10;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = {"a","e","i","o","u"};
		int num =33;
		
			
		System.out.println(solve(num));
	}
	
	public static int solve(int n){
		int[][] dp = new int[52][5];
		dp[1] = new int[]{1,1,1,1,1};
		dp[2] = new int[]{5,4,3,2,1};
		dp[3][0] = 15;
		for(int i=3; i<=n; i++)
		{
			int sum=0;
			for(int j=0; j<5; j++)
			{
				if(j==0) {
					sum+=dp[i][j];
					continue;
				}
				dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
				sum += dp[i][j];
			}
			dp[i+1][0]=sum;
		}
		
		return dp[n+1][0];
	}

}
