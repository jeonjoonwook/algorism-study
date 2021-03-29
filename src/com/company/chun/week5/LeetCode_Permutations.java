class Solution {
    int[] nums;
    boolean[] visited;
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.visited = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            visited[i] = true;
            solution(list);
            visited[i] = false;
        }
        return answer;
    }

    private void solution(List<Integer> list){
        if(list.size() == nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            solution(list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}