package com.company.ingue.firstweek.OrganicCabbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.runAlgorithm();
    }

    public void runAlgorithm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            String line = br.readLine();

            String[] split = line.split(" ");

            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int[][] cabbagePatch = new int[x][y];

            int cabbagePatchNum = Integer.parseInt(split[2]);

            for (int j = 0; j < cabbagePatchNum; j++) {
                String cabbagePathLine = br.readLine();
                String[] cabbagePointArray = cabbagePathLine.split(" ");

                int cabbageXPoint = Integer.parseInt(cabbagePointArray[0]);
                int cabbageYPoint = Integer.parseInt(cabbagePointArray[1]);

                cabbagePatch[cabbageXPoint][cabbageYPoint] = 1;
            }

            System.out.println(calCabbageWhiteEarthwormCount(cabbagePatch));
        }
    }

    private int calCabbageWhiteEarthwormCount(int[][] cabbagePatch) {
        int cabbageWhiteEarthwormCount = 0;

        for (int i = 0; i < cabbagePatch.length; i++) {
            for (int j = 0; j < cabbagePatch[i].length; j++) {
                if (cabbagePatch[i][j] == 1) {
                    cabbageWhiteEarthwormCount++;

                    cabbagePatch[i][j] = 0;
                    navigateCabbagePatch(cabbagePatch, i, j);
                }
            }
        }

        return cabbageWhiteEarthwormCount;
    }

    private void navigateCabbagePatch(int[][] cabbagePatch, int i, int j) {
        Queue<Point> queue = new ArrayDeque();
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int pointI = point.getI();
            int pointJ = point.getJ();

            cabbagePatch[pointI][pointJ] = 0;

            offerIsAdjacent(queue, cabbagePatch, pointI - 1, pointJ);
            offerIsAdjacent(queue, cabbagePatch, pointI + 1, pointJ);
            offerIsAdjacent(queue, cabbagePatch, pointI, pointJ - 1);
            offerIsAdjacent(queue, cabbagePatch, pointI, pointJ + 1);
        }
    }

    private void offerIsAdjacent(Queue<Point> queue, int[][] cabbagePatch, int i, int j) {
        if (isAdjacent(cabbagePatch, i, j)) {
            queue.offer(new Point(i, j));
        }
    }

    private boolean isAdjacent(int[][] cabbagePatch, int i, int j) {
        return isRightPoint(cabbagePatch, i, j) && cabbagePatch[i][j] == 1;
    }

    private boolean isRightPoint(int[][] cabbagePatch, int i, int j) {
        boolean isRightI = (0 <= i && i < cabbagePatch.length);

        return isRightI && 0 <= j && j < cabbagePatch[i].length;
    }
}

class Point {
    private final int i;
    private final int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
