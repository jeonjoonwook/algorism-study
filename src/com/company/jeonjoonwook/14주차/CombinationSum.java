package algorithm_java_string_array_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(solve(candidates, target));
				
	}
	public static List<List<Integer>>solve(int[] candidates, int target)
	{
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtracking(list, new ArrayList<>(), candidates, target, 0);
		return list;		
	}
	public static void backtracking(List<List<Integer>> list,List<Integer> tempList, int[] candidates, int remain, int start) {
		if(remain<0)
			return;
		else if(remain==0)
		{
			list.add(new ArrayList<>(tempList));
		}else {
			for(int i=start; i<candidates.length; i++)
			{
				
				
				tempList.add(candidates[i]);
				backtracking(list, tempList, candidates, remain-candidates[i],i);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	

}
