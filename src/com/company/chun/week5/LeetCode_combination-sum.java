class Solution {
    int T;
    int[] arr;
    List<Integer> tmp;
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        arr = candidates;
        T = target;
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > T)
                break;
            tmp = new LinkedList<>();
            tmp.add(arr[i]);
            solution(i, T - arr[i]);
        }
        return answer;
    }

    private void solution(int idx, int sum){
        if(sum == 0){
            answer.add(new LinkedList<>(tmp));
        }

        for(int i = idx ; i < arr.length ; i++){
            if(sum - arr[i] < 0)
                break;
            tmp.add(arr[i]);
            solution(i, sum - arr[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}