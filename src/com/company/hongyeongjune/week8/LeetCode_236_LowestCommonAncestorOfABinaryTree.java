package com.company.hongyeongjune.week8;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 확인
        if (root == null || root == p || root == q) return root;

        // 이진트리이므로 왼쪽 오른쪽 계속해서 아래로 내려간다.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 올리기
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
