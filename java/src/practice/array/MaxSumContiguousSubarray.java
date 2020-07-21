package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	//	Integer[] arr = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };

		List<Integer> list = new ArrayList(Arrays.asList(arr));
		MaxSumContiguousSubarray mSCS = new MaxSumContiguousSubarray();
		System.out.println(mSCS.maxSubArray(list));

	}

	public int maxSubArray(final List<Integer> A) {
		int maxSum = Integer.MIN_VALUE;
		int runningSum = 0;
		for (int val : A) {
			// Reseting is running sum is negative
			if (runningSum <= 0 && val > runningSum) {
				runningSum = val;
			} else {
				runningSum += val;
			}
			if (runningSum > maxSum) {
				maxSum = runningSum;
			}
		}

		return maxSum;
	}

}
