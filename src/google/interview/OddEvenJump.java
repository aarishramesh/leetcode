package google.interview;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3045/
 * 
 * @author polymath
 *
 */
public class OddEvenJump {
	
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		System.out.println(oddEvenJumps(A));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("hello", "world");
	}
	
	public static int oddEvenJumps(int[] A) {
		int result = 1;
		boolean[] high = new boolean[A.length];
		boolean[] low = new boolean[A.length];
		high[A.length - 1] = low[A.length - 1] = true;
		TreeMap<Integer, Integer> inputMap = new TreeMap<Integer, Integer>();
		inputMap.put(A[A.length - 1], A.length - 1);
		for (int i = A.length - 2; i >= 0; i--) {
			Entry<Integer, Integer> nextHigh = inputMap.ceilingEntry(A[i]);
			if (nextHigh != null) {
				high[i] = low[nextHigh.getValue()];
			}
			Entry<Integer, Integer> nextLow = inputMap.floorEntry(A[i]);
			if (nextLow != null) {
				low[i] = high[nextLow.getValue()];
			}
			if (high[i])
				result++;
			inputMap.put(A[i], i);
		}
		return result;
	}
}
