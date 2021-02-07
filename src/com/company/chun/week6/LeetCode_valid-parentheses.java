class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty() || s.charAt(i) != map.get(stack.pop()))
                return false;
        }

        return stack.isEmpty();
    }
}