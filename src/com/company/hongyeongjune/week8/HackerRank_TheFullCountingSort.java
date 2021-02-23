package com.company.hongyeongjune.week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {

        int[] counting = new int[arr.size()];
        StringBuilder[] answer = new StringBuilder[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            counting[Integer.parseInt(arr.get(i).get(0))]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            int index = counting[Integer.parseInt(arr.get(i).get(0))] -= 1;

            if (i < arr.size() / 2)
                answer[index].append("-");
            else answer[index].append(arr.get(i).get(1));

        }

        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i] + " ");


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        countSort(arr);

        bufferedReader.close();
    }
}


