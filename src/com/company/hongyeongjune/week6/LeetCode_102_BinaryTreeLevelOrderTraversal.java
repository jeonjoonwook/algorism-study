package com.company.hongyeongjune.week6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();
        // 리트코드 테스트케이스에 빈공간도 있어서 넣어줌
        if(root == null) return answer;

        // BFS 로 문제를 해결
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // 현재 큐의 사이즈를 구함
            int size = queue.size();
            // 큐의 사이즈만큼 반복
            for(int i=0; i<size; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                // 현재 큐의 사이즈 만큼 left 와 right 를 담는다.
                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right != null) queue.offer(treeNode.right);
            }
            // 리스트에 추가
            answer.add(temp);
        }

        return answer;
    }
}
