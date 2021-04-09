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
		
		//���� ��հ� ������ ����� ������ ����
		while(left<right)
		{
			//���� ��հ� ������ ����� ũ�⸦ ���ؼ� ���̰� ���� ���� ����� ��ĭ ������
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
