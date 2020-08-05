package amazon.interview.treesandgraphs;

/**
 * https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/514/
 * 
 * @author polymath
 *
 */
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST(root.left, Long.MIN_VALUE, root.val) &&
				isValidBST(root.right, root.val, Long.MAX_VALUE);
	}
	
	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		boolean isLeftBst = isValidBST(root.left, min, root.val);
		boolean isRightBst = isValidBST(root.right, root.val, max);
		if (isLeftBst && isRightBst
				&& root.val > min && root.val < max) 
			return true;
		return false;
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
