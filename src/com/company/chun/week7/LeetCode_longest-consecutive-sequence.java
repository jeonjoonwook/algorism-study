class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int answer = 0, tmp = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == nums[i-1])
                continue;
            
            if(nums[i] != nums[i-1]+1){
                answer = Math.max(answer, tmp);
                tmp = 0;
            }
            tmp++;
        }
        return Math.max(answer, tmp);
    }
}