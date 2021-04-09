package Tree;



class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val=x;
	}
}

public class LCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		System.out.println((solve(root,root.left.right.left,root.left.right.right)).val);// TODO Auto-generated method stub
	}
	
	public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null? right: left;
	}

}
