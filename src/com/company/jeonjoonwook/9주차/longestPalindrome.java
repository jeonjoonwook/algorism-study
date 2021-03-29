package arrayString;


//head , tail 로 양끝 지점 잡아서 이중 for문 돌려서 palindrome 체크 하면 시간 초과 뜸
public class longestPalindrome {
	
	static int index;
	static int maxLen;
	
	public static void main(String[] args) {
		String s="babad";
		
		System.out.println(longestPalindrome(s));
	}
	
	public static String longestPalindrome(String s) {
		int length = s.length();
		if(length<2) {
			return s;
		}
		
		for(int i=0; i<length-1; i++) {
			//홀수인 palindrome 검사
			find(s,i,i);
			//짝수인 palindrome 검사
			find(s,i,i+1);
		}
		
		return s.substring(index,index+maxLen);
	}
	
	public static void find(String s, int i, int j) {
		//중앙을 기준으로 양옆으로 이동하며 palindrome 맞는지 검사
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
		{
			i--;
			j++;
		}
		if(maxLen < j-i-1)
		{
			index = i+1;
			maxLen = j-i-1;
		}
	}

	
}
