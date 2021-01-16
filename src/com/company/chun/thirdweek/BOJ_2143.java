package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long T;
    static int N, M;
    static int[] A, B;
    static List<Long> aSum = new ArrayList<>();
    static List<Long> bSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        //각 배열의 부분합 구하기
        for(int i = 0 ; i < N ; i++){
            long sum = A[i];
            aSum.add(sum);
            for(int j = i+1 ; j < N ; j++){
                sum += A[j];
                aSum.add(sum);
            }
        }

        for(int i = 0 ; i < M ; i++){
            long sum = B[i];
            bSum.add(sum);
            for(int j = i+1 ; j < M ; j++){
                sum += B[j];
                bSum.add(sum);
            }
        }

        aSum.sort(Comparator.naturalOrder());
        bSum.sort(Comparator.naturalOrder());

        long cnt = 0;
        for (long a : aSum) {
            long val = T - a;
            int high = upper_bound(bSum, val);
            int low = lower_bound(bSum, val);
            cnt += high - low;
        }

        System.out.println(cnt);
    }
    // lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
    private static int lower_bound(List<Long> list, long val) {
        int start = 0;
        int end = list.size();
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (list.get(mid) >= val) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    // upper bound는 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
    private static int upper_bound(List<Long> list, long val) {
        int start = 0;
        int end = list.size();
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (list.get(mid) <= val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}