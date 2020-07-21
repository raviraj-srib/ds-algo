package practice.array;

public class RotateArray {
	public void rotate(int[][] matrix) {

		makeTranspose(matrix);
		int start = 0;
		int end = matrix[0].length - 1;

		while (start < end) {
			swapColumns(matrix, start, end);
			start++;
			end--;
		}
	}

	private void swapColumns(int[][] arr, int col1, int col2) {
		int size = arr[0].length;

		for (int row = 0; row < size; row++) {
			int temp = arr[row][col1];
			arr[row][col1] = arr[row][col2];
			arr[row][col2] = temp;
		}
	}

	private void makeTranspose(int[][] arr) {
		int size = arr[0].length;

		for (int row = 0; row < size; row++) {
			for (int col = row + 1; col < size; col++) {
				if (col != row) {
					int temp = arr[row][col];
					arr[row][col] = arr[col][row];
					arr[col][row] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(mat);
//	makeTranspose(mat);
		print(mat);
	}

	private static void print(int[][] arr) {
		int size = arr[0].length;

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
}
