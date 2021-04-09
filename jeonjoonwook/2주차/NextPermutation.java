package arrayString;

import java.util.Arrays;

public class NextPermutation {
	//leetCode Next Permutation
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int[] nums2 = {3,2,1};
		int[] nums3 = {6,9,5,4,2,1};
		
		int[] result = change(nums3);
		
		print(result);
	}
	
	static int[] change(int[] nums)
	{
		boolean flag = true;
		int boundary = nums.length-1;
		int[] result = new int[nums.length];
		
		for(int i=boundary; i>0; i--)
		{
			if(nums[i-1]<nums[i])
			{
				flag=false;
				boundary=i-1;
				break;
			}
		}
		
		if(flag)
		{
			Arrays.sort(nums);			
		}else {
			
			int j = boundary+1;
			while(j<nums.length && (nums[j]-nums[boundary])>0) {
				j++;
			}
			
			int temp = nums[boundary];
			nums[boundary]=nums[j-1];
			nums[j-1] = temp;
			Arrays.sort(nums, boundary+1, nums.length);
		}
		
		
		return nums;
	}
	
	static void print(int[] nums)
	{
		for(int i=0; i<nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}

}
