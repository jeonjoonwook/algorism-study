package arrayString;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] nums = {1,8,6,2,5,4,8,3,7};		
		System.out.println(solve(nums));
	}
	
	public static int solve(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int result = (right-left)*Math.min(nums[left],nums[right]);
		
		//왼쪽 기둥과 오른쪽 기둥이 만날때 까지
		while(left<right)
		{
			//왼쪽 기둥과 오른쪽 기둥의 크기를 비교해서 길이가 작은 쪽의 기둥을 한칸 움직임
			if(nums[left]<=nums[right]) {
				left++;
			}else {
				right--;
			}
			
			result = Math.max(result, (right-left)*Math.min(nums[left], nums[right]));
		}
		return result;
	}

}
