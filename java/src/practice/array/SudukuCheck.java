package practice.array;

import java.util.HashSet;

public class SudukuCheck {

	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> valueArray = new HashSet<Character>();

		if (!checkRows(board, valueArray)) {
			return false;
		}

		if (!checkColumns(board, valueArray)) {
			return false;
		}

		if (!checkInnerSquares(board, valueArray)) {
			return false;
		}

		return true;
	}

	private boolean checkRows(char[][] arr, HashSet<Character> valueArray) {
		for (int row = 0; row < 9; row++) {
			valueArray.clear();
			for (int col = 0; col < 9; col++) {
				if (arr[row][col] != '.') {
					if (!valueArray.add(arr[row][col])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkColumns(char[][] arr, HashSet<Character> valueArray) {
		for (int col = 0; col < 9; col++) {
			valueArray.clear();
			for (int row = 0; row < 9; row++) {
				if (arr[row][col] != '.') {
					if (!valueArray.add(arr[row][col])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkInnerSquares(char[][] arr, HashSet<Character> valueArray) {
		for (int row = 0; row < 9; row = row + 3) {
			for (int col = 0; col < 9; col = col + 3) {
				if (!checkInnerSquareOf3(arr, valueArray, row, col)) {
					return false;
				}
			}
		}
		return true;

	}

	private boolean checkInnerSquareOf3(char[][] arr, HashSet<Character> valueArray, int iInit, int jInit) {
		valueArray.clear();
		for (int i = iInit, iEnd = iInit + 3; i < iEnd; i++) {
			for (int j = jInit, jEnd = jInit + 3; j < jEnd; j++) {
				if (arr[i][j] != '.') {
					if (!valueArray.add(arr[i][j])) {
						return false;
					}
				}
			}

		}

		return true;
	}

}
