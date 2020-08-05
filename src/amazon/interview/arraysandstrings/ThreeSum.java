package amazon.interview.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2966/
 * 
 * https://leetcode.com/articles/3sum/
 * 
 * @author polymath
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum instance = new ThreeSum();
		int[] nums = {0, 0, 0 -1, 1, 0};
		List<List<Integer>> result = instance.threeSum(nums);
		result.stream().forEach(list -> System.out.println(list.toString()));
	}

	/**
	 * Solution with Sorting and Two pointer
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumTwoPointer(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for(int i = 0; i < nums.length - 2; i++) {
			if(i != 0 && nums[i] == nums[i - 1])
				continue;
			twoSumTwoPointer(nums, i, res);
		}

		return res;
	}

	private void twoSumTwoPointer(int[] nums, int i, List<List<Integer>> res) {
		int l = i + 1, r = nums.length - 1;
		while(l < r) {
			int sum = nums[i] + nums[l] + nums[r];
			if(sum > 0 || r != nums.length - 1 && nums[r] == nums[r + 1])
				r--;
			else if(sum < 0 || l != i + 1 && nums[l] == nums[l - 1])
				l++;
			else
				res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
		}
	}

	/**
	 * Sorting and hashset
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSum(nums, i, res);
			}
		return res;
	}

	void twoSum(int[] nums, int i, List<List<Integer>> res) {
		HashSet<Integer> seen = new HashSet<Integer>();
		for (int j = i + 1; j < nums.length; ++j) {
			int complement = -nums[i] - nums[j];
			if (seen.contains(complement)) {
				res.add(Arrays.asList(nums[i], nums[j], complement));
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					++j;
			}
			seen.add(nums[j]);
		}
	}

	/**
	 * Solution without sorting
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumWithoutSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList<List<Integer>>(res);
    }
}
