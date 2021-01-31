package com.company.ingue.January31th.mergeTwoSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 머지소트의 merge 메소드를 응용해서 풀었습니다.
 *
 * 시간복잡도 O(N)
 * 공간복잡도 O(N)
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode lastPoint = start;

        while (l1 != null && l2 != null) {
            ListNode nextNode;

            if (l1.val < l2.val) {
                nextNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                nextNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            lastPoint.next = nextNode;
            lastPoint = nextNode;
        }

        while (l1 != null) {
            ListNode nextNode = new ListNode(l1.val);

            lastPoint.next = nextNode;
            lastPoint = nextNode;

            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode nextNode = new ListNode(l2.val);

            lastPoint.next = nextNode;
            lastPoint = nextNode;

            l2 = l2.next;
        }

        return start.next;
    }
}