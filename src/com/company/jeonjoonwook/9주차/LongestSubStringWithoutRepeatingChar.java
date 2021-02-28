package arrayString;

import java.util.HashSet;
import java.util.Set;

//마지막 케이스에서 시간 초과 나옴
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
				//subString이 반복되는 char가 없으면 subString,result max값 비교 
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
		//Set으로 반복되는 Character있는지 찾기
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
