package arrayString;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		//int[] nums = {4,5,6,7,0,1,2};
		//int[] nums = {4,5,6,7,0,1,2};
		int[] nums = {6,7,0,1,2,4,5};
		
		System.out.println(solve(nums, 7));
	}
	
	public static int solve(int[] nums, int target) {
		int left =0;
		int right = nums.length -1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(nums[mid] == target)
				return mid;
			//int[] nums = {4,5,6,7,0,1,2}; 
			if(nums[left]<=nums[mid]) {
				if(target>=nums[left] && target <= nums[mid])
					right = mid -1;
				else
					left = mid+1;
			//{6,7,0,1,2,4,5}; ÄÉÀÌ½º
			}else {
				System.out.println("hihi");
				if(target>=nums[mid] && target <= nums[right])
					left = mid +1;
				else
					right = mid -1;
			}
			
		}
		return -1;
	}
	

}
