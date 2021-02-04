class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int answer = 0;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            answer = Math.max(answer, (right - left) * minHeight);
            if(minHeight == height[left])
                left++;
            else
                right--;
        }
        return answer;
    }
}