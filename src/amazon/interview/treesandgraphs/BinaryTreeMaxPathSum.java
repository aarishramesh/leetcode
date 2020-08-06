package amazon.interview.treesandgraphs;

/**
 * 
 * 
 * @author polymath
 *
 */
public class BinaryTreeMaxPathSum {

	private static int maxSum = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0, null, null);
		System.out.println(maxPathSum(root));
		
	}
	
	public static int maxPathSum(TreeNode root) {
		maxPathSumInternal(root);
		return maxSum;
	}

	private static int maxPathSumInternal(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = maxPathSumInternal(root.left);
		int rightMax = maxPathSumInternal(root.right);
		int maxSingle = Math.max(root.val + Math.max(leftMax, rightMax), root.val);
		maxSum = Math.max(maxSum, Math.max(maxSingle, root.val + leftMax + rightMax));
		return maxSingle;
	}

	public static class TreeNode {
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
