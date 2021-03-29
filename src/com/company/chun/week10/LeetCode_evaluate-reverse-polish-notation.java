class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.charAt(s.length()-1) >= '0' && s.charAt(s.length()-1) <= '9') {
                stack.push(Integer.valueOf(s));
                continue;
            }
            int second = stack.pop();
            int first = stack.pop();
            stack.push(operate(s, first, second));
        }
        return stack.pop();
    }

    private int operate(String s, int first, int second) {
        switch (s){
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }
        return -1;
    }
}