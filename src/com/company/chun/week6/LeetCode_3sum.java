class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){
                int val = nums[i] + nums[left] + nums[right];
                if(val == 0){
                    answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                }
                if(val < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(answer);
    }
}