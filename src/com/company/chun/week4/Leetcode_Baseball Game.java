class Solution {
    //TimeComplex: O(n)
    public int calPoints(String[] ops) {
        Stack<Integer> history = new Stack<>();//점수를 저장할 stack
        for (String op : ops) {
            switch (op) {
                case "D":
                    history.push(history.peek() * 2);
                    break;
                case "C":
                    history.pop();
                    break;
                case "+":
                    int i1 = history.pop();
                    int i2 = history.pop();
                    history.push(i2);
                    history.push(i1);
                    history.push(i1 + i2);
                    break;
                default:
                    history.push(Integer.parseInt(op));
                    break;
            }
        }
        int answer = 0;
        while(!history.isEmpty())
            answer += history.pop();
        return answer;
    }
}