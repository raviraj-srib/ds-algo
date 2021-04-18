package company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon1 {
	public static void main(String[] args) {
		Integer[] array = {7,1,3};
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));
		
		System.out.println(howManySwaps(arr));

	}

	public static long howManySwaps(List<Integer> arr) {
		long count = 0;
		for (int i = 0, size = arr.size(); i < size; i++) {
			int min = arr.get(i);
			int index = i;
			for (int j = i + 1; j < size; j++) {
				if (min > arr.get(j)) {
					min = arr.get(j);
					index = j;
				}
			}
			if (i != index) {
				count++;
				int temp = arr.get(i);
				arr.set(i, arr.get(index));
				arr.set(index, temp);
			}
		}

		return count;

	}

}
