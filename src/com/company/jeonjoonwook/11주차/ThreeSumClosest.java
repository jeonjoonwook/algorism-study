package algorithm_study;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,2,1,-4};
		int target =1;
		System.out.println(solve(nums, target));
		
	}
	
	public static int solve(int[] nums, int target)
	{
		int min = 99999;
		int result =0;
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length; i++)
		{
			int j = i+1;
			int k = nums.length - 1;
			while(j<k)
			{
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(sum - target);
				
				if(diff == 0)
					return sum;
				
				if(diff < min) {
					min = diff;
					result = sum;
				}
				
				if(sum<=target)
				{
					j++;
				}else {
					k--;
				}
				
			}
			
		}
		return result;		
	}

}
