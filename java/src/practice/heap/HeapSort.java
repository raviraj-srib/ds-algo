package practice.heap;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		System.out.println("hello");
		Integer[] data = { 80, 50, 30, 25, 35, 18, 28, 36 };
		heapify(data);

	}

	public static void heapify(Integer[] heap) {
		System.out.println("before calling heapify : " + Arrays.toString(heap));
		int curIndex = heap.length - 1;
		int parentIndex = (curIndex - 1) / 2;
		while (parentIndex >= 0 && (heap[parentIndex] < heap[curIndex])) {
			int temp = heap[curIndex];
			heap[curIndex] = heap[parentIndex];
			heap[parentIndex] = temp;
			curIndex = parentIndex;
			parentIndex = (curIndex - 1) / 2;

		}
		
		System.out.println("After calling heapify : " + Arrays.toString(heap));

	}

}
