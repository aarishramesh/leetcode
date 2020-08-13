package twilio.interview;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 * 
 * @author polymath
 *
 */
public class UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;
		boolean isLeftUvt = true;
		if (root.left != null) {
			if (root.val == root.left.val) {
				isLeftUvt = isUnivalTree(root.left);
			} else
				return false;
		}
		boolean isRightUvt = true;
		if (root.right != null) {
			if (root.val == root.right.val)
				isRightUvt = isUnivalTree(root.right);
			else
				return false;
		}
		return isLeftUvt && isRightUvt;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
