package com.company.ingue.January17th.FindFirstandLastPositionofElementinSortedArray;

public class Solution {

    /**
     * 시간복잡도 : O(logN)
     *
     * --> 최댓값 찾는 복잡도 O(logN) + binarySearch O(lonN) = O(logN)
     *
     * 공간복잡도 : O(1)
     *
     * --> 파라미터로 받은 배열 이외에 새로 선언한 자료구조가 없음
     *
     * 아이디어 : 배열이 rotated 되어있기 때문에 최댓값 인덱스를 찾고
     *
     *  array1     array2
     * [~~~~~~ max ~~~~~~]
     *
     * 중에서 target 위치를 파악 후
     *
     * binarySearch(array1, target) 으로 인덱스 검색 (만약 target이 array1에 있는 경우 )
     *
     * @param nums 배열
     * @param target 타켓
     * @return 타켓에 해당되는 값이 있으면 해당 인덱스, 없다면 -1
     */
    public int search(int[] nums, int target) {
        int maxIndex = getMaxIndex(nums); // 최댓값 서치

        // 만약 target이 왼쪽 array에 있다면
        if(isTargetOnLeftArray(nums, maxIndex, target)) {
            return binarySearch(nums, target, 0, maxIndex); // 왼쪽 binarySearch
        }

        return binarySearch(nums, target, maxIndex+1, nums.length-1); // 오른쪽 binarySearch
    }

    /**
     * target이 최댓값을 기준으로 나누어진 두 개의 배열중에서 왼쪽에 있는지 확인하는 메소드
     *
     * @param nums
     * @param maxIndex
     * @param target
     * @return
     */
    private boolean isTargetOnLeftArray(int[] nums, int maxIndex, int target) {
        return nums[0] <= target && target <= nums[maxIndex];
    }

    /**
     * 최댓값 찾는 메소드 ( binarySearch 응용 )
     * @param nums
     * @return
     */
    private int getMaxIndex(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;

        while(left < right) {
            //만약 남은 index에서 right가 가장 클 경우 right를 리턴
            if(nums[left] < nums[right]) {
                return right;
            }

            mid = (left + right) / 2;

            //mid가 left가 클 경우 최댓값은 mid <= max < right 사이에 존재
            if(nums[left] < nums[mid]) {
                left = mid;
                right--;
            }
            //만약 mid가 작을 경우 최댓값은 left <= max < mid 사이에 존재
            else {
                right = mid - 1;
            }
        }

        //남은 경우는 left right 두개가 남아있을 때 left가 큰 경우나, 두개 인덱스가 같은 경우이기 때문에 left 리턴
        return left;
    }

    /**
     * binarySearch
     *
     * 배열의 일부를 받아야 했기 때문에 left, right 인덱스 파라미터를 추가로 설정
     *
     * @param nums
     * @param target
     * @param l
     * @param r
     * @return
     */
    public int binarySearch(int[] nums, int target, int l, int r) {
        int left = l;
        int right = r;

        int mid;

        while(left <= right) {
            mid = (left + right) / 2;

            if(nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] > target) {
                right = mid-1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
