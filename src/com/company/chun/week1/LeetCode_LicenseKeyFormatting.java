class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1 ; i >= 0; i--){
            if(S.charAt(i) == '-')
                continue;

            sb.append(S.charAt(i));
            if(sb.length() == K){
                stack.push(sb.reverse().toString());
                sb = new StringBuilder();
            }
        }
        if(sb.length() != 0){
            stack.push(sb.reverse().toString());
            sb = new StringBuilder();
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append('-');
        }
        if(sb.length() == 0)
            return "";
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}