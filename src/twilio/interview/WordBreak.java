package twilio.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, int start, int[] result, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
		if (start == s.length()) {
			return true;
		}
		if (memo[start] != null) {
			return memo[start];
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
				return memo[start] = true;
			}
		}
		return memo[start] = false;
	}

	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		List<String> dict = new ArrayList<String>(Arrays.asList("aaaa", "aaa"));
		System.out.println(obj.wordBreak("aaaaaaa", dict));
	}
}
