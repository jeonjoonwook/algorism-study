package backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		GenerateParenthesis a = new GenerateParenthesis();
		System.out.println(a.generateParenthesis_dfs(4));
	}
	public List<String> generateParenthesis_dfs(int n){
		List<String> res = new ArrayList<>();
		dfs(res, "", n,n);
		return res;
	}
	// '(' left , ')' right �ǹ�
	private void dfs(List<String> list, String str, int left, int right) {
		
		// '(' �� ')' ���� ���� ���� �־�� ���� ������ ������
		if(left < 0 || left > right)
		{
			return;
		}
		if(left==0 && right==0)
		{
			list.add(str);
			return;
		}
		dfs(list, str+'(', left-1,right);
		dfs(list, str+')', left,right-1);
		
	}
}
