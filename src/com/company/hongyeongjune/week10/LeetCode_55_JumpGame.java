package com.company.hongyeongjune.week10;

public class Solution {
    public boolean canJump(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) continue;
            int jump = Math.min(i + nums[i], nums.length-1);
            for(int j=i; j<=jump; j++) {
                visited[j] = true;
            }
        }

        return visited[nums.length-1];

    }
}
