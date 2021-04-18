package practice.bsearch;

import java.util.List;



public class FindElementInAlmostSortedTree {

	public boolean isElementPresent(List<Integer> data, Integer key) {
		boolean isPresent = false;
		int low = 0;
		int high = data.size() - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (data.get(mid) == key) {
				return true;
			} else {
				if (data.get(low) < data.get(mid) && key >= data.get(low) && key <= data.get(mid) ) {
					//sorted'
					isElementPresentBS(data,key, low, mid);
				} else if (data.get(mid) < data.get(high) && key >= data.get(mid) && key <= data.get(high)) {
					//sorted
					isElementPresentBS(data,key, mid, high);
				} else {
					isElementPresent(data,key);
				}
			}
			
		}
		int pivoitElement = getPivotElement(data);
		isPresent = isElementPresentBS(data, key, 0, pivoitElement - 1)
				|| isElementPresentBS(data, key, pivoitElement, data.size() - 1);
		return isPresent;

	}

	private boolean isElementPresentBS(List<Integer> data, Integer key, int low, int high) {
		while (low < high) {
			int mid = (low + high) / 2;
			if (data.get(mid) == key) {
				return true;
			} else if (data.get(mid) > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	private int getPivotElement(List<Integer> data) {
		
		// TODO Auto-generated method stub
		return 0;
	}
}

/*
 *  p   left and right greater
 * p-1    right will be lesser
50 

30,40,50,60, 10,20
0           i=4      n
mid = 2 -> 5

left --
hight = 1


*/