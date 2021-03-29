class Solution {
    private int[][] alpha;
    private static final int ALPHA_CNT = 26;
    //Time Complex : n^2
    public List<List<String>> groupAnagrams(String[] strs) {
        //각 단어의 알파벳 사용 횟수를 이차원배열로 저장(소문자가 아니면 map)
        alpha = new int[strs.length][ALPHA_CNT];
        boolean[] visited = new boolean[strs.length];
        for(int i = 0 ; i < strs.length ; i++){
            for(int j = 0 ; j < strs[i].length() ; j++){
                alpha[i][strs[i].charAt(j) - 'a']++;
            }
        }

        //아나그램 판별
        List<List<String>> answer = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++){
            if(visited[i])
                continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for(int j = 0 ; j < strs.length ; j++){
                if(i == j || visited[j])
                    continue;
                if(isAnagram(i, j)){
                    visited[j] = true;
                    list.add(strs[j]);
                }
            }
            answer.add(list);
        }
        return answer;
    }

    private boolean isAnagram(int i, int j) {
        for(int k = 0 ; k < ALPHA_CNT ; k++){
            if(alpha[i][k] != alpha[j][k])
                return false;
        }
        return true;
    }
}