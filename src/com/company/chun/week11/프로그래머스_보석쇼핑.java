import java.util.*;


class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int tmpStartIdx = 0;
        int startIdx = 0;
        int length = Integer.MAX_VALUE;
        for(String gem : gems){
            map.merge(gem, 1, Integer::sum);
            queue.offer(gem);
            while(map.get(queue.peek()) > 1){
                map.put(queue.peek(), map.get(queue.peek())-1);
                queue.poll();
                tmpStartIdx++;
            }

            if(map.size() == gemSet.size() && length > queue.size()){
                length = queue.size();
                startIdx = tmpStartIdx;
            }
        }
        return new int[]{startIdx+1, startIdx + length};
    }
}