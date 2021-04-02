package algorithm_java_string_array_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {-1,-100,3,99};
		int k =2;
		int[] result=solve(nums, k);
		for(int i=0; i<result.length; i++)
		{
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] solve(int[] nums, int k) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<nums.length; i++)
		{
			q.add(nums[i]);
		}
		for(int i=0; i<k; i++)
		{
			int temp=q.poll();
			q.add(temp);
		}
		int[] result= new int[nums.length];
		
		for(int i=0; i<nums.length; i++)
		{
			result[i]=q.poll();
		}
		return result;
	}

}
