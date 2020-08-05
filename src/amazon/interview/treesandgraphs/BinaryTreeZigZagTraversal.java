package amazon.interview.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/
 * 
 * @author polymath
 *
 */
public class BinaryTreeZigZagTraversal {

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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<NodeObject> nodesQueue = new LinkedList<NodeObject>();
		nodesQueue.add(new NodeObject(root, 0));
		while (!nodesQueue.isEmpty()) {
			NodeObject obj = nodesQueue.remove();
			if (obj.node.left != null) {
				nodesQueue.add(new NodeObject(obj.node.left, obj.level + 1));
			}
			if (obj.node.right != null) {
				nodesQueue.add(new NodeObject(obj.node.right, obj.level + 1));
			}
			if (obj.level >= result.size() || result.get(obj.level) == null)
				result.add(obj.level, new LinkedList<Integer>());
			if (obj.level % 2 == 0)
				((LinkedList<Integer>)result.get(obj.level)).addLast(obj.node.val);
			else
				((LinkedList<Integer>)result.get(obj.level)).addFirst(obj.node.val);
		}
		return result;
	}
	
	static class NodeObject {
		TreeNode node;
		int level;
		public NodeObject(TreeNode node, int level) {
			super();
			this.node = node;
			this.level = level;
		}
	}
}
