package arrayString;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));
	}
	// 기둥의 왼쪽 max값(왼쪽 맥스값보다 본인 기둥이 더 크면 본인 기둥이 왼쪽 맥스 값)과 오른쪽 max 값중 작은 것 - 본인 기둥 높이
		
	public static int trap(int[] height) {
		int result =0;
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		int max = height[0];
		left[0] = height[0];
        //왼쪽 기둥 max값 구하기		
		for(int i=1; i<height.length; i++)
		{
			if(height[i] < max)
			{
				left[i] = max;
			}else {
				left[i] = height[i];
				max = height[i];
			}
		}
		//오른쪽 기둥 맥스값 구하기
		max = height[height.length-1];
		right[height.length-1] = height[height.length-1];
		for(int i=height.length-2; i>=0; i--)
		{
			if(height[i]<max)
			{
				right[i]=max;
			}else {
				right[i]=height[i];
				max = height[i];
			}
		}
		//왼쪽 기둥 맥스값과 오른쪽 기둥 맥스값중 작은것 - 본인 기둥 높이
		for(int i=0; i<height.length; i++) {
			result += Math.min(left[i], right[i])-height[i];
		}
		return result;
	}
}