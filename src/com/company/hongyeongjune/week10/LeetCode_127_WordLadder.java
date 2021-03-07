package com.company.hongyeongjune.week10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public class Node {
        String next;
        int count;

        public Node(String next, int count) {
            this.next = next;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int answer = 0;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(beginWord, 0));
        boolean[] visited = new boolean[wordList.size()];

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.next.equals(endWord)) {
                answer = node.count + 1;
                break;
            }

            for (int i = 0; i < wordList.size(); i++) {

                if (!visited[i] && isCheck(node.next, wordList.get(i))) {
                    visited[i] = true;
                    queue.offer(new Node(wordList.get(i), node.count + 1));
                }
            }

        }

        return answer;

    }

    public boolean isCheck(String first, String second) {

        int count = 0;
        for (int i = 0; i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }

        return true;
    }

}

