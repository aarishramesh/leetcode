package amazon.interview.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * @author polymath
 *
 */
public class GenerateParenthesis {

	public static void main(String[] args) {
		GenerateParenthesis instance = new GenerateParenthesis();
		System.out.println(instance.generateParenthesis(1));
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n > 0)	
			generateParenthesisInternal(n, n, new StringBuilder(), result);
		return result;
	}

	private void generateParenthesisInternal(int openBraces, int closedBraces, StringBuilder parenthesisStr
			, List<String> result) {

		if (openBraces < 0 || closedBraces < 0)
			return;

		if (openBraces == 0 && closedBraces == 0 && parenthesisStr.charAt(parenthesisStr.length() - 1) == ')') {
			result.add(parenthesisStr.toString());
			return;
		} 

		generateParenthesisInternal(openBraces - 1, closedBraces, parenthesisStr.append("(")
				, result);
		parenthesisStr.deleteCharAt(parenthesisStr.length() - 1);
		if (openBraces < closedBraces) {
			generateParenthesisInternal(openBraces, closedBraces - 1, parenthesisStr.append(")")
					, result);
			parenthesisStr.deleteCharAt(parenthesisStr.length() - 1);
		}
	}

	List<String> res;
	
	/**
	 * Generate parenthesis V2 - 1 ms - 
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesisV2(int n) {
		res = new LinkedList<>();
		build(new StringBuilder(), 0, 0, n);
		return res;
	}

	private void build(StringBuilder sb, int open, int closed, int n) {
		if(closed == n && open == n) res.add(sb.toString());
		else {
			if(open < n) {
				sb.append('(');
				build(sb, open + 1, closed, n);
				sb.deleteCharAt(sb.length() - 1);
			}
			if (open > closed) {
				sb.append(')');
				build(sb, open, closed + 1, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
