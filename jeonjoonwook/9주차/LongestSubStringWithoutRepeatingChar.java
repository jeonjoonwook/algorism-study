package arrayString;

import java.util.HashSet;
import java.util.Set;

//������ ���̽����� �ð� �ʰ� ����
public class LongestSubStringWithoutRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "abcabcbb";
		//String s = "bbbbb";
		String s = "pwwkew";
		
		int result=0;
		
		for(int i=0; i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				String subString = s.substring(i, j);
				//subString�� �ݺ��Ǵ� char�� ������ subString,result max�� �� 
				if(distinctChar(subString))
				{
					result= Math.max(subString.length(), result);
				}
			}
		}
		System.out.println(result);
	}
	
	static boolean distinctChar(String subString)
	{
		//Set���� �ݺ��Ǵ� Character�ִ��� ã��
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<subString.length(); i++)
		{
			if(!set.add(subString.charAt(i)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	

}
