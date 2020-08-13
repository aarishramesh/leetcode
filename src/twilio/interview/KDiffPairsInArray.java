package twilio.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/ 
 *
 */
public class KDiffPairsInArray {
	public int findPairs(int[] nums, int k) {
		int result = 0;

		HashMap <Integer,Integer> counter = new HashMap<>();
		for (int n: nums) {
			counter.put(n, counter.getOrDefault(n, 0)+1);
		}


		for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
			int x = entry.getKey();
			int val = entry.getValue();
			if (k > 0 && counter.containsKey(x + k)) {
				result++;
			} else if (k == 0 && val > 1) {
				result++;
			}
		}
		return result;
	}
}
