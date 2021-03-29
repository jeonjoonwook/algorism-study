package com.company.hongyeongjune.week1;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        List<Jewelry> jewelries = new ArrayList<>();
        List<Integer> bag = new ArrayList<>();

        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jewelries.add(new Jewelry(
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())
            ));
        }

        for(int i=0; i<K; i++) {
            bag.add(Integer.parseInt(bufferedReader.readLine()));
        }

        jewelries.sort((o1, o2) -> o1.weight - o2.weight);
        bag.sort((o1, o2) -> o1 - o2);

        long answer = 0;
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<K; i++) {
            while(index < N && jewelries.get(index).weight <= bag.get(i)) {
                priorityQueue.offer(jewelries.get(index++).price);
            }
            if(!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }

        bufferedWriter.write(answer + "");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static class Jewelry {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

}

