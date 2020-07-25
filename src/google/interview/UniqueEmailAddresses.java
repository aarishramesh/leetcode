package google.interview;

import java.util.HashSet;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
 * 
 * @author polymath
 *
 */
public class UniqueEmailAddresses {
	
	public static void main(String[] args) {
		String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(input));
	}
	
	public static int numUniqueEmails(String[] emails) {
		HashSet<String> uniqueEmails = new HashSet<String>();
		for (String email : emails) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			while (email.charAt(idx) != '@') {
				if (email.charAt(idx) == '+') {
					idx++;
					break;
				}
				if (email.charAt(idx) == '.') {
					idx++;
					continue;
				}
				sb.append(email.charAt(idx++));
			}
			if (email.charAt(idx) == '@') {
				sb.append(email.substring(idx, email.length()));
			} else {
				sb.append(email.substring(email.indexOf('@'), email.length()));
			}
			uniqueEmails.add(sb.toString());
		}
		return uniqueEmails.size();
	}
}
