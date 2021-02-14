package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> ranked = new LinkedList<>();
        while (st.hasMoreTokens()) {
            ranked.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> player = new LinkedList<>();
        while (st.hasMoreTokens()) {
            player.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(Solution.climbingLeaderboard(ranked, player));
    }

    //O(N*M)에서 O(2logM + N + M)으로 줄여봤지만 계속 시간초과 
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < player.size(); i++) {
            players.add(new Player(i, player.get(i)));
        }
        players.sort(Player::compareTo);


        int rank = 1, playerIdx = 0, rankIdx = 0;
        while (playerIdx < players.size() && rankIdx < ranked.size()) {
            if (rankIdx > 0 && ranked.get(rankIdx).equals(ranked.get(rankIdx - 1))) {
                rankIdx++;
                continue;
            }

            if (ranked.get(rankIdx) > players.get(playerIdx).score) {
                rank++;
                rankIdx++;
            } else {
                players.get(playerIdx).rank = rank;
                playerIdx++;
            }
        }

        //남은 player의 점수에 꼴등 점수 넣기
        for (int i = playerIdx; i < players.size(); i++) {
            players.get(i).rank = rank;
        }

        //다시 인덱스를 중심으로 정렬
        players.sort(Comparator.comparing(p -> p.idx));
        List<Integer> answer = new LinkedList<>();
        for (Player p : players) {
            answer.add(p.rank);
        }
        return answer;
    }

    static class Player implements Comparable<Player> {
        int idx, score, rank = -1;

        public Player(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
            return o.score - score;
        }
    }
}
