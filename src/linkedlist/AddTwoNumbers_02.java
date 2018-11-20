package linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * @author polymath
 *
 */
public class AddTwoNumbers_02 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2); ListNode n2 = new ListNode(4);
		n1.next = n2; 
		ListNode m1 = new ListNode(5); ListNode m2 = new ListNode(6); ListNode m3 = new ListNode(4);
		m1.next = m2; m2.next = m3;
		
		ListNode result = addTwoNumbers(n1, m1);
		do {
			System.out.print(result.val + " ");
		} while ((result = result.next) != null);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode result = root;
		int carry = 0, sum = 0;
		while (l1 != null || l2 != null) {
			ListNode newNode = new ListNode(0);
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
			newNode.val = sum % 10;
			carry = sum / 10;
			root.next = newNode;
			root = newNode;
		}
		if (carry > 0) {
			ListNode newNode = new ListNode(carry);
			root.next = newNode;
		}
		return result.next;
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
}
