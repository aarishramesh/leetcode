package twilio.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * @author polymath
 *
 */
public class ReconstructItinerary {
	
	/**
	 * Runtime - 6ms. Space - 49 mb for all test cases
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<ItineraryNode>> ticketsMap = new HashMap<String,
				List<ItineraryNode>>();		
		for (List<String> ticket : tickets) {
			if (!ticketsMap.containsKey(ticket.get(0))) 
				ticketsMap.put(ticket.get(0), new ArrayList<ItineraryNode>());
			ticketsMap.get(ticket.get(0)).add(new ItineraryNode(ticket.get(1)));
		}
		ticketsMap.entrySet().forEach(entry -> Collections.sort(entry.getValue()));

		List<String> result = new ArrayList<String>();
		String jfk = "JFK";
		result.add(jfk);
		createItinerary(jfk, ticketsMap, result, tickets.size() + 1);
		return result;
	}

	private void createItinerary(String segment, Map<String, List<ItineraryNode>> ticketNodesMap, List<String> result, int expected) {
		if (result.size() == expected) {
			return;
		}
		if (ticketNodesMap.get(segment) != null) {
			for (ItineraryNode entry : ticketNodesMap.get(segment)) {
				if (!entry.isVisited) {
					entry.isVisited = true;
					result.add(entry.node);
					createItinerary(entry.node, ticketNodesMap, result, expected);
					if (result.size() == expected)
						return;
					entry.isVisited = false;
					result.remove(result.size() - 1);
				}
			}
		}
	}

	class ItineraryNode implements Comparable<ItineraryNode> {
		private String node;
		private boolean isVisited;


		public ItineraryNode(String node) {
			super();
			this.node = node;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.hashCode();
			result = prime * result + (isVisited ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItineraryNode other = (ItineraryNode) obj;
			if (!this.equals(other))
				return false;
			if (isVisited != other.isVisited)
				return false;
			return true;
		}
		@Override
		public int compareTo(ItineraryNode obj) {
			// TODO Auto-generated method stub
			return this.node.compareTo(obj.node);
		}
	}

	public static void main(String[] args) {
		ReconstructItinerary instance = new ReconstructItinerary();
		List<List<String>> tickets = new ArrayList<List<String>>();
		//[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		//[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
		tickets.add(new ArrayList<String>(Arrays.asList("EZE", "AXA")));
		tickets.add(new ArrayList<String>(Arrays.asList("TIA", "ANU")));
		tickets.add(new ArrayList<String>(Arrays.asList("ANU", "JFK")));
		tickets.add(new ArrayList<String>(Arrays.asList("JFK", "ANU")));
		tickets.add(new ArrayList<String>(Arrays.asList("ANU", "EZE")));
		tickets.add(new ArrayList<String>(Arrays.asList("TIA", "ANU")));
		tickets.add(new ArrayList<String>(Arrays.asList("AXA", "TIA")));
		tickets.add(new ArrayList<String>(Arrays.asList("TIA", "JFK")));
		tickets.add(new ArrayList<String>(Arrays.asList("ANU", "TIA")));
		tickets.add(new ArrayList<String>(Arrays.asList("JFK", "TIA")));


		System.out.println(instance.findItinerary(tickets));
	}

	/**
	 * Runtime - 13ms. Space - 49 mb for all test cases
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItineraryV2(List<List<String>> tickets) {
		List<Itinerary> input = new ArrayList<>();
		for (List<String> ticket : tickets) {
			input.add(new Itinerary(ticket.get(0), ticket.get(1)));
		}
		Collections.sort(input);
		List<String> output = new ArrayList<>();
		boolean[] used = new boolean[input.size()];
		findItineraryUtil(input, used, "JFK", output, 0);
		return output;
	}

	boolean findItineraryUtil(List<Itinerary> input, boolean[] used, String end, List<String> output, int count) {
		if (count == used.length) {
			output.add(end);
			return true;
		}
		for (int i = 0; i < input.size(); i++) {
			if (used[i]) {
				continue;
			}
			Itinerary itr = input.get(i);
			if (itr.start.equals(end)) {
				output.add(itr.start);
				used[i] = true;
				if (findItineraryUtil(input, used, itr.dest, output, count + 1)) {
					return true;
				}
				used[i] = false;
				output.remove(output.size() - 1);
			}
		}
		return false;
	}

	class Itinerary implements Comparable<Itinerary> {
		String start;
		String dest;
		Itinerary(String start, String dest) {
			this.start = start;
			this.dest = dest;
		}

		@Override
		public int compareTo(Itinerary other) {
			if (this.start.equals(other.start)) {
				return this.dest.compareTo(other.dest);
			} else {
				return this.start.compareTo(other.start);
			}
		}
	}
}
