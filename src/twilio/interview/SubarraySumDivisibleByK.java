package twilio.interview;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * @author polymath
 *
 */
public class SubarraySumDivisibleByK {

	public static void main(String[] args) {
		int[] arr = {4,5,0,-2,-3,1};
		System.out.println(subarraysDivByK(arr, 5));
	}

	public static int subarraysDivByK(int[] nums, int K) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey((sum % K + K) % K))
				count += map.get((sum % K + K) % K);
			map.put((sum % K + K) % K, map.getOrDefault((sum % K + K) % K, 0) + 1);
		}
		return count;
	}
}
