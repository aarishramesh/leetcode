package dynamicprogramming;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * @author polymath
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int maxRect = 0;
		if (matrix != null && matrix.length > 0) {
			int[] rectHistogram = new int[matrix[0].length];
			MaxAreaHistoram obj = new MaxAreaHistoram();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == '1')
						rectHistogram[j] += 1;
					else
						rectHistogram[j] = 0;
				}
				maxRect = Math.max(maxRect, obj.largestRectangleArea(rectHistogram));
			}
		}
		return maxRect;
	}

	public class MaxAreaHistoram {
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
}
