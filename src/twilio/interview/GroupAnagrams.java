package twilio.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = null;
		Map<Set<Character>, List<String>> anagramMap = new HashMap<Set<Character>, List<String>>();
		for (String str : strs) {
			HashSet<Character> charSet = new HashSet<Character>();
			for (int i = 0; i < str.length(); i++) {
				charSet.add(str.charAt(i));
			}
			if (anagramMap.containsKey(charSet)) {
				anagramMap.get(charSet).add(str);
			} else {
				ArrayList<String> wordsList = new ArrayList<String>();
				wordsList.add(str);
				anagramMap.put(charSet, wordsList);
			}
		}
		result = new ArrayList<List<String>>(anagramMap.values());
		return result;
	}
}
