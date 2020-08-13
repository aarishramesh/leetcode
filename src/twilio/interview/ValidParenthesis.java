package twilio.interview;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author polymath
 *
 */
public class ValidParenthesis {

	public static void main(String[] args ) {
		ValidParenthesis obj = new ValidParenthesis();
		System.out.println(obj.isValid("(((({{{}}}[[[[]]]])))"));
	}

	public boolean isValid(String s) {
		
		Stack<Character> parenthesisStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				parenthesisStack.add('(');
			} else if (s.charAt(i) == ')') {
				if (parenthesisStack.size() > 0 && parenthesisStack.peek() == '(') {
					parenthesisStack.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == '{')
				parenthesisStack.add('{');
			else if (s.charAt(i) == '}') {
				if (parenthesisStack.size() > 0 && parenthesisStack.peek() == '{')
					parenthesisStack.pop();
				else
					return false;
			} else if (s.charAt(i) == '[')
				parenthesisStack.add('[');
			else if (s.charAt(i) == ']') {
				if (parenthesisStack.size() > 0 && parenthesisStack.peek() == '[')
					parenthesisStack.pop();
				else
					return false;
			} else {
				return false;
			}
		}
		if (parenthesisStack.size() == 0)
			return true;
		return false;

	}
}
