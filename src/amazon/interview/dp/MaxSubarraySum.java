package amazon.interview.dp;

public class MaxSubarraySum {
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		for (int i = 0; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSum = Math.max(maxEndingHere, maxSum);
		}
		return maxSum;
	}
}
