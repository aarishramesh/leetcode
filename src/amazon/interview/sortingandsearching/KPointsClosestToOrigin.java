package amazon.interview.sortingandsearching;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2996/
 * 
 * @author polymath
 *
 */
public class KPointsClosestToOrigin {

	public static void main(String[] args) {
		int[][] input = {{1, 3}, {-2, 2}};
		int[][] result = kClosest(input, 1);
		System.out.println(result.length);
	}

	/**
	 * Minheap solution using lambda
	 * 
	 * @param points
	 * @param K
	 * @return
	 */
	public static int[][] kClosestV2(int[][] points, int K) {
		int[][] res = new int[K][];
		PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) ->
		o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]
				);
		for (int[] poi : points) {
			p.offer(poi);
		}
		int pSize = p.size();
		int f = pSize > K ? K : pSize;
		for (int i = 0; i < f; i++) {
			res[i] = p.poll();
		}
		return res;
	}

	/**
	 * Divide and conquer using quick select algorithm
	 * 
	 * @param points
	 * @param K
	 * @return
	 */
	public int[][] kClosestQuickSelect(int[][] points, int K) {
		quickSelect(points, K, 0, points.length-1);
		return Arrays.copyOfRange(points, 0, K);
	}
	
	public void quickSelect(int[][] points, int k, int start, int end) {
		if (start == end) {
			return;
		}
		int p = dist(points[(start+end)/2]);
		int i = start;
		int j = end;
		while (i <= j) {
			while (i <= j && dist(points[i]) < p) {
				i++;
			}
			while (i <= j && dist(points[j]) > p) {
				j--;
			}
			if (i <= j) {
				int[] tmp = points[j];
				points[j] = points[i];
				points[i] = tmp;
				i++;
				j--;
			}
		}
		if (k <= j+1) {
			quickSelect(points, k, start, j);
		}
		if (k >= i+1) {
			quickSelect(points, k, i, end);
		}
		return;
	}
	public int dist(int[] point) {
		return point[0]*point[0] + point[1]*point[1];
	}

	/**
	 * Minheap solution
	 * 
	 * @param points
	 * @param K
	 * @return
	 */
	public static int[][] kClosest(int[][] points, int K) {
		if (points != null) {
			PriorityQueue<Point> queue = new PriorityQueue<Point>();
			for (int i = 0; i < points.length; i++) {
				queue.add(new Point(points[i][0], points[i][1]));
			}
			int[][] result = new int[K][2];
			int i = 0;
			while (i < K) {
				Point point = queue.remove();
				result[i][0] = point.x;
				result[i][1] = point.y;
				i++;
			}
			return result;
		}
		return null;
	}

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point obj) {
			if (obj.equals(this))
				return 0;
			double objDist = Math.sqrt((obj.x * obj.x) + (obj.y * obj.y)); 
			double thisDist = Math.sqrt((this.x * this.x) + (this.y * this.y));
			if (thisDist < objDist)
				return -1;
			else if (thisDist > objDist)
				return 1;
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
