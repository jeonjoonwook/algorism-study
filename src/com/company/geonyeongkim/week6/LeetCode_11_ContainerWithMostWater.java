package com.company.geonyeongkim.week6;

public class LeetCode_11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int answer = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                answer = Math.max(answer, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        LeetCode_11_ContainerWithMostWater containerWithMostWater = new LeetCode_11_ContainerWithMostWater();
        int ans = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{1, 1});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{4, 3, 2, 1, 4});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{1, 2, 1});
        System.out.println(ans);
    }
}
