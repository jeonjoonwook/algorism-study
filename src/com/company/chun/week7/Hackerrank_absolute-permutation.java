public class Solution {

    static int[] absolutePermutation(int n, int k) {
        int[] answer = new int[n];
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int v1 = (i + 1) - k;
            int v2 = (i + 1) + k;
            if (v1 > 0 && !arr[v1]) {
                arr[v1] = true;
                answer[i] = v1;
            }else if (v2 <= n && !arr[v2]) {
                arr[v2] = true;
                answer[i] = v2;
            }else{
                return new int[]{-1};
            }
        }
        return answer;
    }
}