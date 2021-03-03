package com.company;

import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Solution.getMinimumCost(5, new int[]{1,2,3,4}));
    }

    static int getMinimumCost(int k, int[] c) {
        if(k < c.length){
            sortDec(c, 0, c.length-1);
        }else{
            sortAsc(c, 0, c.length-1);
        }
        int sum = 0, multiple = 1, idx = 0;
        while (idx < c.length) {
            int i = idx, len = Math.min(idx + k, c.length);
            while(i < len){
                sum += c[i] * multiple;
                i++;
            }
            idx = i;
            multiple++;
        }
        return sum;
    }
    static void sortDec(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] > pivot) left++;
            while(data[right] < pivot) right--;
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sortDec(data, l, right);
        if(r > left) sortDec(data, left, r);
    }

    static void sortAsc(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sortDec(data, l, right);
        if(r > left) sortDec(data, left, r);
    }
}
