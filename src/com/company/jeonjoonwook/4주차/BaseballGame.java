package queueStack;

import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
		String[] strs = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(strs));		
	}
	//숫자는 스택에 그냥 넣으면 되고, C는 마지막 요소 빼기, D는 마지막요소 더블링해서 넣기, +는 마지막 두 요소 더하기
	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		
		for(String op : ops) {
			switch(op) {
			    //마지막 요소 두개 더해서 넣기
				case "+":
					int x = stack.pop();
					int y = stack.pop();
					stack.push(y);
					stack.push(x);
					stack.push(x+y);
					break;
				//마지막 요소 더블링 해서 넣기	
				case "D":
					stack.push(stack.peek()*2);
					break;
				//마지막 요소 빼기
				case "C":
					stack.pop();
					break;
				default:
					stack.push(Integer.valueOf(op));
			}
		}
		int sum =0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		return sum;
	}

}
