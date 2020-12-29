package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 차례대로가 아닌 증가 감소라면?
public class Main {
    private final static int N = 8;

    private static final int[] arr = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = arr[1] > arr[0];
        for(int i = 1 ; i < N ; i++){
            if(checkMixed(i, flag)){
                System.out.println("mixed");
                return;
            }
        }

        if(flag)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }

    private static boolean checkMixed(int idx, boolean flag){
        return (arr[idx] > arr[idx-1] && !flag)
                || (arr[idx] < arr[idx-1] && flag)
                || (arr[idx] == arr[idx-1]);
    }
}