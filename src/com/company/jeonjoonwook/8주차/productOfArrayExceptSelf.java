package arrayString;

public class productOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,2,3,4 };
		int[] result = solve(nums);
		for(int i=0; i<result.length; i++)
		{
			System.out.println(" "+result[i]);
		}
	}
	
	public static int[] solve(int[] nums) {
		
		int left = 1;
        int right = 1;
        int[] product = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            product[i] = left;
            left *= nums[i]; 
        }
        
        for(int i=0; i<product.length; i++)
        {
        	System.out.println(" "+product[i]);
        }
        
        for(int i = nums.length -1; i > -1; i--)
        {
            product[i] = right*product[i];  // left * right
            right *= nums[i];             
        }
        return product;	
	}

}
