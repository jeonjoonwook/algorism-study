package arrayString;

public class DivideTwoInteger {
	//leetcode devideTwoIntegers
	
	//-2147483648 -1 넣으면 왜 0나오지
	public static void main(String[] args) {
		int dividend = -2147483648;
		System.out.println(dividend);
		int divisor = -1;
		int result = divide(dividend, divisor);
		System.out.println(result);
	}
	
	static int divide(int dividend, int divisor) {
		
		int result=0;
		
		if(divisor==1)
		{
			return dividend;
		}
		int sign =1;
		if((dividend <0 && divisor >0) || (dividend >0 && divisor<0))
		{
			sign = -1;
		}
		
		if(dividend <0)
		{
			dividend = dividend *-1;
		}
		if(divisor <0)
		{
			divisor = divisor *-1;
		}
		while(dividend>=divisor)
		{
			dividend= dividend-divisor;
			if(dividend>=0)
			{
				result++;				
			}
		}
		return result*sign;
	}

}
