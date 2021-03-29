class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            indexMap.put(wordList.get(i), i);
        }
        int len = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean isFounded = false;
        while(!queue.isEmpty() && !isFounded){
            len++;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                String s = queue.poll();
                if(s.equals(endWord)){
                    isFounded = true;
                    break;
                }
                for(int k = 0 ; k < wordList.size() ; k++){
                    if(visited[k])
                        continue;
                    if(check(s, wordList.get(k))){
                        visited[indexMap.get(wordList.get(k))] = true;
                        queue.offer(wordList.get(k));
                    }
                }
            }
        }

        return isFounded ? len : 0;
    }

    private boolean check(String src, String dest) {
        int diff = 0, idx = 0;
        while(idx < src.length() && diff < 2){
            if(src.charAt(idx) != dest.charAt(idx)){
                diff++;
            }
            idx++;
        }
        return diff < 2;
    }
}