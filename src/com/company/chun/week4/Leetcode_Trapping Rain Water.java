class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        
        int start = 0, end = height.length-1;
        int minHeight = 0, total = 0;
        while(start < end){
            if(height[start] < minHeight){
                total += minHeight - height[start];
                height[start] = minHeight;
            }
            if(height[end] < minHeight){
                total += minHeight - height[end];
                height[end] = minHeight;
            }

            minHeight =Math.max(minHeight, Math.min(height[start], height[end]));
            if(height[end] < height[start]){
                end--;
            }else{
                start++;
            }
        }
        return total;
    }
}