package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * @author polymath
 *
 */
public class MaximumAreaInHistogram {

	public static void main(String[] args) {
		MaximumAreaInHistogram obj = new MaximumAreaInHistogram();
		int[] heights = {4, 2, 2, 10};
		System.out.println(obj.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		if (heights != null && heights.length > 0) {
			Stack<Integer> barStack = new Stack<Integer>();
			int i = 0;
			while (i < heights.length) {
				while (barStack.isEmpty() || i < heights.length && heights[i] >= heights[barStack.peek()]) {
					barStack.push(i++);
				}
				if (i < heights.length) {
					while (!barStack.isEmpty() && (heights[barStack.peek()] > heights[i])) {
						int j = barStack.pop();
						if (!barStack.isEmpty())
							maxArea = Math.max(maxArea, (i - barStack.peek() - 1) * heights[j]);
						else
							maxArea = Math.max(maxArea, i * heights[j]);
					}
					barStack.push(i++);
				}
			}

			while (!barStack.isEmpty()) {
				int j = barStack.pop();
				if (!barStack.isEmpty())
					maxArea = Math.max(maxArea, (i - barStack.peek() - 1) * heights[j]);
				else
					maxArea = Math.max(maxArea, i * heights[j]);
			}
		}
		return maxArea;
	}
}
