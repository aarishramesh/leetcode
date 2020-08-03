package google.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3047/
 * 
 * @author polymath
 *
 */
public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringOptimised(" "));
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		if (s != null) {
			int j = 0, i = 0; 
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			while (j < s.length()) {
				if (charMap.containsKey(s.charAt(j))) {
					i = Math.max(charMap.get(s.charAt(j)), i);
				}
				maxLen = Math.max(maxLen, j - i + 1);
				charMap.put(s.charAt(j), j + 1);
				j++;
			}
		}	
		return maxLen;
	}
	
	public static int lengthOfLongestSubstringOptimised(String s) {
		int maxLen = 0;
		if (s != null) {
			int j = 0, i = 0;
			int[] charIdx = new int[128];
			while (j < s.length()) {
				if (charIdx[s.charAt(j)] != -1)
					i = Math.max(charIdx[s.charAt(j)], i);
				maxLen = Math.max(maxLen, j - i + 1);
				charIdx[s.charAt(j)] = j + 1;
				j++;
			}
		}
		return maxLen;
	}
}
