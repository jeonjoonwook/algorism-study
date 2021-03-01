package arrayString;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		String [] wordDict = {"leet","code"};
		Set<String> set = new HashSet();
		for(int i=0; i<wordDict.length;i++)
		{
			set.add(wordDict[i]);
		}
		System.out.println(solution(s, set, 0));
	}
	
	public static boolean solution(String s, Set<String> dict, int start)
	{
		if(start == s.length())
			return true;
		
		for(String a: dict) {
			int len = a.length();
			int end = start+len;
			
			if(end > s.length())
				continue;
			if(s.substring(start, start+len).equals(a))
				if(solution(s, dict, start+len))
					return true;
		}
		return false;
	}
	

}
