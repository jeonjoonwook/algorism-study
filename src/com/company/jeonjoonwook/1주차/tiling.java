package dynamic;

import java.math.BigInteger;
import java.util.*;

//백준 1793 타일링

public class tiling {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		BigInteger[] DP = new BigInteger[251];
		
		DP[0] = new BigInteger("1");
		DP[1] = new BigInteger("1");
		DP[2] = new BigInteger("3");
		for(int i=3; i<251; i++)
		{
			DP[i] = DP[i-2].multiply(new BigInteger("2"));
			DP[i] = DP[i].add(DP[i-1]);
		}
		
		while(scan.hasNextInt())
		{
			int num = Integer.parseInt(scan.next());
			System.out.println(DP[num]);
		}

	}

}
