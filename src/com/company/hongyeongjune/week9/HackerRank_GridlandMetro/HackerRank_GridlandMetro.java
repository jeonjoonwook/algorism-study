package com.company.hongyeongjune.week9.HackerRank_GridlandMetro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        int row;
        int start;
        int end;

        public Pair(int row, int start, int end) {
            this.row = row;
            this.start = start;
            this.end = end;
        }

        public int getRow() {
            return row;
        }

        public int getStart() {
            return start;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        if (k == 0) {
            bufferedWriter.write(BigInteger.valueOf(n * m).toString());
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
            return;
        }

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < track.length; i++) pairList.add(new Pair(track[i][0], track[i][1], track[i][2]));

        pairList.sort(Comparator.comparing(Pair::getRow).thenComparing(Pair::getStart));

        int row = pairList.get(0).row;
        int start = pairList.get(0).start;
        int end = pairList.get(0).end;

        List<Pair> answerList = new ArrayList<>();

        for (int i = 1; i < pairList.size(); i++) {

            if (pairList.get(i).row != row) {
                answerList.add(new Pair(row, start, end));
                row = pairList.get(i).row;
                start = pairList.get(i).start;
                end = pairList.get(i).end;
                continue;
            }

            if (pairList.get(i).start <= end) {
                end = Math.max(end, pairList.get(i).end);
            } else {
                answerList.add(new Pair(row, start, end));
                start = pairList.get(i).start;
                end = pairList.get(i).end;
            }
        }

        answerList.add(new Pair(row, start, end));

        BigInteger answer = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));

        for (Pair pair : answerList) {
            answer = answer.subtract(BigInteger.valueOf(pair.end - pair.start + 1));
        }

        bufferedWriter.write(answer.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}