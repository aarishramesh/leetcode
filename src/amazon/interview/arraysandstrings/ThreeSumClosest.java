package amazon.interview.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/
 * 
 * @author polymath
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] input = {0, 0, 0, 0};
		int target = 2;
		System.out.println(threeSumClosest(input, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Result result = new Result();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			tscIntl(nums, i, target, result);
		}
		return target - result.diff;
	}

	private static void tscIntl(int[] nums, int i, int target, Result result) {
		int l = i + 1, r = nums.length - 1;
		while (l < r) {
			int sum = nums[i] + nums[l] + nums[r];
			if (Math.abs(target - sum) < Math.abs(result.diff))
				result.diff = target - sum;
			if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
	}

	static class Result {
		int diff = Integer.MAX_VALUE;
	}
	
	
	/**
	 * Solution with runtime 10 ms
	 * 
	 */
	int diff;
    int currSum;
    
    public int threeSumClosestV2(int[] numbers, int target) {
        Arrays.sort(numbers);
        int n = numbers.length;
        diff = Integer.MAX_VALUE;
        currSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            checkSum(numbers, i, target);
            if (currSum == target) return currSum;
        }
        return currSum;
    }
    
    private void checkSum(int[] numbers, int currIndex, int target) {
        int left = currIndex + 1;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right] + numbers[currIndex];
            if (sum == target) {
                currSum = sum;
                diff = 0;
                break;
            } else if (sum < target) {
                if (target - (sum) < diff) {
                    diff = target - (numbers[left] + numbers[right] + numbers[currIndex]);
                    currSum = sum;
                }
                left++;
            } else {
                if (sum - target < diff) {
                    diff = sum - target;
                    currSum = sum;
                }
                right--;
            }
        }
    }
}
