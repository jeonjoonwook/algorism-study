package arrayString;


//head , tail �� �糡 ���� ��Ƽ� ���� for�� ������ palindrome üũ �ϸ� �ð� �ʰ� ��
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
			//Ȧ���� palindrome �˻�
			find(s,i,i);
			//¦���� palindrome �˻�
			find(s,i,i+1);
		}
		
		return s.substring(index,index+maxLen);
	}
	
	public static void find(String s, int i, int j) {
		//�߾��� �������� �翷���� �̵��ϸ� palindrome �´��� �˻�
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
