package com.company.hongyeongjune.week8.ICT.문제1번;

public class Main {

    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    public static long getNumber(SinglyLinkedListNode binary) {

        String answer = "";

        while (binary.next != null) {
            answer += binary.data;
            binary = binary.next;
        }

        answer += binary.data;

        return Long.parseLong(answer, 2);

    }
}
