class Solution {
    int[] arr;
    StringBuilder sb = new StringBuilder();
    List<String> answer = new LinkedList<>();
    List<List<Character>> list = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        initArr();
        char[] tmp = digits.toCharArray();
        arr = new int[tmp.length];
        for(int i = 0 ; i < tmp.length ; i++){
            arr[i] = tmp[i] - '0';
        }
        dfs(0);
        return answer;
    }

    private void dfs(int idx){
        if(idx == arr.length){
            answer.add(sb.toString());
            return;
        }

        for(char c : list.get(arr[idx])){
            sb.append(c);
            dfs(idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void initArr(){
        for(int i = 0 ; i < 10 ; i++){
            list.add(new LinkedList<>());
        }
        list.get(2).add('a');list.get(2).add('b');list.get(2).add('c');
        list.get(3).add('d');list.get(3).add('e');list.get(3).add('f');
        list.get(4).add('g');list.get(4).add('h');list.get(4).add('i');
        list.get(5).add('j');list.get(5).add('k');list.get(5).add('l');
        list.get(6).add('m');list.get(6).add('n');list.get(6).add('o');
        list.get(7).add('p');list.get(7).add('q');list.get(7).add('r');list.get(7).add('s');
        list.get(8).add('t');list.get(8).add('u');list.get(8).add('v');
        list.get(9).add('w');list.get(9).add('x');list.get(9).add('y');list.get(9).add('z');
    }
}