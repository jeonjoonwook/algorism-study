package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final static int N = 9;

    private static final int[] arr = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(checkAscending())
            System.out.println("ascending");
        else if(checkDescending())
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
    private static boolean checkAscending(){
        for(int i = 1 ; i < N ; i++){
            if(arr[i] != i)
                return false;
        }
        return true;
    }

    private static boolean checkDescending(){
        int tmp = 8;
        for(int i = 1 ; i < N ; i++, tmp--){
            if(arr[i] != tmp)
                return false;
        }
        return true;
    }
}