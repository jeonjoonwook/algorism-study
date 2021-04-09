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
		//candidates 오름차순으로 sorting
		Arrays.sort(candidates);
		backtracking(list, new ArrayList<>(), candidates, target, 0);
		return list;		
	}
	//backtracking 인자 (결과 리스트 값, 현재 리스트 값 , candidate array, 목표 까지 남은 값, 시작 값)
	public static void backtracking(List<List<Integer>> list,List<Integer> tempList, int[] candidates, int remain, int start) {
		//현재 리스트 값의 합이 target 보다 크면 return
		if(remain<0)
			return;
		//현재 리스트 값의 합이 target과 같으면 결과 리스트 값에 add
		else if(remain==0)
		{
			list.add(new ArrayList<>(tempList));
		}
		//현재 리스트 값의 합이 target보다 작으면 현재 idx값부터 끝까지 add 하면서 backtracking 수행
		else {
			for(int i=start; i<candidates.length; i++)
			{				
				tempList.add(candidates[i]);
				backtracking(list, tempList, candidates, remain-candidates[i],i);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	

}
