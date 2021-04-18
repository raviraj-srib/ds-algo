package practice.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WaterCaptureInBuilding {
	public static void main(String[] args) {
		// Integer[] arr = { 10, 3, 5, 3, 8, 6, 3, 4 };

		Integer[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		List<Integer> input = Arrays.asList(arr);
		System.out.println("MaxDrop that can be captured : " + getMaxDropCaptured(input));
	}

	private static int getMaxDropCaptured(List<Integer> input) {
		int maxDrop = 0;
	//	Stack<Integer> stack = new Stack<Integer>();
		int size = input.size();
		Integer[] leftMax = new Integer[size];
		Integer[] rightMax = new Integer[size];

		leftMax[0] = -1;
		rightMax[size - 1] = -1;
		int currentMaxElement = input.get(0);
		//stack.push(input.get(0));
		for (int i = 1; i < size; i++) {
			if (currentMaxElement > input.get(i)) {
				leftMax[i] =currentMaxElement;
			} else {
				currentMaxElement = input.get(i);
				//stack.push(input.get(i));
				leftMax[i] = leftMax[i - 1];
			}
		}
		//System.out.println(stack);
		//System.out.println(Arrays.toString(leftMax));

		currentMaxElement = input.get(size - 1);
		//stack.push(input.get(size - 1));
		for (int i = size - 2; i >= 0; i--) {
			if (currentMaxElement > input.get(i)) {
				rightMax[i] = currentMaxElement;
			} else {
				currentMaxElement = input.get(i);
				//stack.push(input.get(i));
				rightMax[i] = rightMax[i + 1];
			}
		}

		//System.out.println(stack);
		//System.out.println(Arrays.toString(rightMax));
		for (int i = 1; i < size - 1; i++) {
			if (leftMax[i] != -1 && rightMax[i] != -1) {
				int boundry = Math.min(leftMax[i], rightMax[i]);
				int storedWater = boundry - input.get(i);
				if (storedWater > 0) {
					maxDrop = maxDrop + storedWater;
				}
				//System.out.println("Index:" + i + " Element:" + input.get(i) + " Left:" + leftMax[i] + " right:" + rightMax[i]);
			}
		}
		return maxDrop;
	}

}
