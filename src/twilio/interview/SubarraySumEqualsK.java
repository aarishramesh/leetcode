package twilio.interview;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * @author polymath
 *
 */
public class SubarraySumEqualsK {
	public static int subarraysEqualsK(int[] nums, int K) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - K))
				count += map.get(sum - K);
			map.put(sum , map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
