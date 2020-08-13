package twilio.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author polymath
 *
 */
public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber instance = new LetterCombinationsOfPhoneNumber();
		System.out.println(instance.letterCombinations("2375"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits != null && !digits.isEmpty()) {
			Map<Character, List<Character>> digitsCharMap = new HashMap<Character, List<Character>>();
			digitsCharMap.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
			digitsCharMap.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
			digitsCharMap.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
			digitsCharMap.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
			digitsCharMap.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
			digitsCharMap.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
			digitsCharMap.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
			digitsCharMap.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));

			letterCombinations(digits, 0, new StringBuilder(), result, digitsCharMap);
		}
		return result;
	}

	private void letterCombinations(String input, int idx, StringBuilder sb, List<String> result
			, Map<Character, List<Character>> digitsCharMap) {
		if (idx == input.length()) {
			result.add(sb.toString());
			return;
		}
		List<Character> digitChars = digitsCharMap.get(input.charAt(idx));
		idx++;
		for (Character digitChar : digitChars) {
			sb.append(digitChar);
			letterCombinations(input, idx, sb, result, digitsCharMap);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
