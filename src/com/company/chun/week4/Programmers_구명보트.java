import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1, pair = 0, single = 0;
        while (start <= end) {
            if (start == end || people[start] + people[end] > limit) {
                single++;
                end--;
            } else {
                pair++;
                start++;
                end--;
            }
        }
        return pair + single;
    }
}