package algorithm_java_string_array_10;

import java.util.Arrays;
import java.util.Scanner;

//น้มุ 11399

public class greedyAtm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int[] input = new int[count];
		
		for(int i=0; i<input.length; i++)
		{
			input[i]=sc.nextInt();
		}
		
		int result = solve(input);
		System.out.println(result);
	}
	
	public static int solve(int[] input)
	{
		int result=0;
		Arrays.sort(input);
		
		int[] greedyArr = new int[input.length];
		greedyArr[0]=input[0];
		
		for(int i=1; i<input.length; i++)
		{
			greedyArr[i]=greedyArr[i-1]+input[i];
		}
		for(int i=0; i<greedyArr.length; i++)
		{
			result+=greedyArr[i];
		}
		
		return result;
	}

}
