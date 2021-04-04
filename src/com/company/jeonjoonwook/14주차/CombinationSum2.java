package algorithm_java_string_array_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target=8;
		
		System.out.println(solve(candidates, target));
	}
	
	public static List<List<Integer>> solve(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(candidates);		
		backtracking(result, new ArrayList<>(),candidates,0,target,0);
		
		return result;		
	}
	
	public static void backtracking(List<List<Integer>> result, List<Integer> now,int[] candidates, int sum, int target, int start) {
		
		if(sum>target)
		{
			return;
		}else if(sum==target)
		{			
			result.add(new ArrayList<>(now));
		}else {
			for(int i=start; i<candidates.length; i++)
			{
				//i가 시작점이 아니고 i-1 값과 같으면 넘긴다. 중복되는 결과가 나오기 때문
				 if(i !=start && candidates[i] == candidates[i-1]) { 
					 continue; 
				 }
				 			
				now.add(candidates[i]);
				//combinationSum 문제와 차이점은 하나의 원소를 여러번 사용 못하므로 i+1 해줌
				backtracking(result, now, candidates, candidates[i]+sum,target,i+1);
				now.remove(now.size()-1);
			}
		}
				
	}
	

}
