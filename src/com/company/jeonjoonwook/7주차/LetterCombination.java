package backTracking;

import java.util.*;

public class LetterCombination {

	public static void main(String[] args) {
		LetterCombination a = new LetterCombination();
		
		System.out.println(a.solve("23"));
	}
	
	public List<String> solve(String digits) {
		String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();
		
		if(digits.length()==0)
		{
			return result;
		}
		
		result.add("");
		//digitletter에서 하나씩 꺼내면서 결과물과 조합 
		for(int i=0; i<digits.length(); i++)
			result = combine(digitletter[digits.charAt(i)-'0'],result);
		
		return result;
	}

	public List<String> combine(String digit, List<String> firstList) {
		
		List<String> result = new ArrayList<String>();
		
		for(int i=0; i<digit.length(); i++)
		{
			for(String firstStr : firstList)
				result.add(firstStr + digit.charAt(i));
		}
		
		return result;
	}

}
