package com.company.hongyeongjune.week8;

package 해커링크.sorting.FradulentActivityNotifications;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int answer = 0;
        int[] count = new int[201];

        // 중앙값을 알기위해 주어진 d 만큼 개수를 추가한다.
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {

            // 중앙값 찾기
            double center = findCenter(count, d);

            if (expenditure[i] >= center * 2) answer++;

            // 첫 번째 값 개수 빼기
            count[expenditure[i - d]]--;
            // 새로 추가된 값 개수 추가
            count[expenditure[i]]++;
        }

        return answer;
    }

    private static double findCenter(int[] count, int d) {

        int median = 0;
        double result = 0;

        // 홀수
        if (d % 2 != 0) {
            for (int i = 0; i < count.length; i++) {

                median += count[i];

                // 차례대로 더한 개수가 d 의 절반 만큼 되었을 때 중앙값이다.
                if (median > d / 2) {
                    return result = i;
                }
            }
        } else {

            int first = 0;
            int second = 0;

            for (int i = 0; i < count.length; i++) {
                median += count[i];

                // 두 개의 중앙값 구하기
                if (first == 0 && median >= d / 2) first = i;
                if (second == 0 && median >= d / 2 + 1) {
                    second = i;
                    break;
                }
            }

            return result = (first + second) / 2.0;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


