package amazon.interview.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(TreeNode root) {
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
				result.add(obj.level, new ArrayList<Integer>());
			result.get(obj.level).add(obj.node.val);
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
	
	public List<List<Integer>> levelOrderV2(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root != null) {
			q.offer(root);
		}
		TreeNode cur;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> subAns = new LinkedList<Integer>();
			for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
				cur = q.poll();
				subAns.add(cur.val);                // visit the root
				if (cur.left != null) {
					q.offer(cur.left);              // push left child to queue if it is not null
				}
				if (cur.right != null) {
					q.offer(cur.right);             // push right child to queue if it is not null
				}
			}
			ans.add(subAns);
		}
		return ans;
	}

}
