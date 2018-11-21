package hashing;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * Solution : Using hashtable and two pointers
 */
public class LongestNonRepeatingSubString_03 {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbacde"));
		System.out.println(lengthOfLongestSubstring("bbbbbaaaaabcv"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int i = 0, j = 0, maxLen = 0;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		while (j < s.length()) {
			if (!charMap.containsKey(s.charAt(j))) {
				charMap.put(s.charAt(j), j);
				int len = j - i + 1;
				if (len > maxLen)
					maxLen = len;
			} else {
				int charIdx = charMap.get(s.charAt(j));
				for (int k = i; k <= charIdx; k++)
					charMap.remove(s.charAt(k));
				i =  charIdx + 1;
				charMap.put(s.charAt(j), j);
			}
			j++;
		}
		return maxLen;
	}

}
