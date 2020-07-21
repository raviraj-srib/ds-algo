package practice.bsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartition {

	public static void main(String[] args) {
		PainterPartition sol = new PainterPartition();
		// ArrayList<Integer> list = new ArrayList();
		// list.add(1);
		// list.addAll(
		//Integer arr[] = { 1, 10 };
		// Integer arr[] = { 185, 186, 938, 558, 655, 461, 441, 234, 902, 681 };
		 Integer arr[] = {640, 435, 647, 352, 8, 90, 960, 329, 859};
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		System.out.println(sol.paint(3, 10, list));
		// System.out.println(sol.getFinalAnswer(100,5));
	}

	public int paint(int A, int B, ArrayList<Integer> C) {
		int unitToBePainted = 0;
		if (C.size() > A) {
			unitToBePainted = getMaxUnitToBePainted(A, C);
		} else {
			unitToBePainted = getMaxOfArrayList(C);
		}
		return getFinalAnswer(unitToBePainted, B);
	}

	private int getMaxOfArrayList(ArrayList<Integer> walls) {
		int maxValue = 0;
		for (int wall : walls) {
			if (wall > maxValue) {
				maxValue = wall;
			}
		}
		return maxValue;
	}

	private int getFinalAnswer(int unitToBePainted, int cost) {
		if (cost == 1) {
			return unitToBePainted;
		}
		int total = 2 * getFinalAnswer(unitToBePainted, cost / 2) + (unitToBePainted * (cost % 2));
		return total % 10000003;
	}

	private int getMaxUnitToBePainted(int painterCount, ArrayList<Integer> walls) {
		int maxUnitTime = Integer.MAX_VALUE;
		int low = walls.get(0);
		int high = 0;
		for (int wall : walls) {
			high += wall;
		}
		while (low <= high) {
			int mid = (low + high) / 2;
			int totalPartition = 1;
			int partialSum = 0;
			int maxSum = 0;
			for (int i = 0, len = walls.size(); i < len; i++) {
				int wall = walls.get(i);
				if ((partialSum + wall) > mid) {
					if (partialSum > maxSum) {
						maxSum = partialSum;
					}
					totalPartition++;
					partialSum = wall;
				} else {
					partialSum += wall;
				}
			}
			if (partialSum > maxSum) {
				maxSum = partialSum;
			}

			if (totalPartition > painterCount) {
				low = mid + 1;
			} else {
				high = mid - 1;
				if (totalPartition == painterCount) {
					if (maxSum < maxUnitTime) {
						maxUnitTime = maxSum;
					}

				}

			}
		}
		return maxUnitTime;

	}
}
