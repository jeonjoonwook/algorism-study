package arrayString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		//String s = "AAAAAAAAAAAAA";
		System.out.println(solve(s));
		
	}
	public static List<String> solve(String s) {
	   Set<String> sequence = new HashSet<>();
	   Set<String> result = new HashSet<>();
	   for(int i=0; i<=s.length()-10; i++)
	   {
		   String sub = s.substring(i, i+10);
		   if(!sequence.add(sub))
		   {
			   result.add(sub);
		   }
	   }
	   return new ArrayList<>(result);
	}

}
