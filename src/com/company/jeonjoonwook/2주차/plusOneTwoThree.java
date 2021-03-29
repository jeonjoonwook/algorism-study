package dynamic;

import java.util.*;

public class plusOneTwoThree {

	public static void main(String[] args) {
		int dp[] = new int[12];
		
		Scanner scan = new Scanner(System.in);
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4; i<=10; i++)
		{
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
		}
		
		int num = scan.nextInt();
		for(int j=0; j<num; j++)
		{
			int n = scan.nextInt();
			System.out.println(dp[n]);
		}
		
	}

}
