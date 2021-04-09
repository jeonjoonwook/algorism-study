package bruteForce;

import java.util.*;

public class BlackJack {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int result = 0;
		int num = scan.nextInt();
		int target = scan.nextInt();
		
		int[] arr = new int[num];
		for(int i=0; i<num; i++)
		{
			arr[i] = scan.nextInt();
		}
		
		for(int i=0; i<num-2; i++) {
			for(int j=i+1; j<num-1; j++)
			{
				for(int k=j+1; k<num; k++)
				{
					int sum = arr[i]+arr[j]+arr[k];
					if(sum<=target)
					{
						result = Math.max(sum, result);
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
