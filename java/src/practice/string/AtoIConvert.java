package practice.string;

public class AtoIConvert {
	public int myAtoi(String str) {
		if (str != null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		boolean isNegative = false;
		int index = 0;
		if (str.charAt(index) == '-') {
			isNegative = true;
			index++;
		} else if (str.charAt(index) == '+') {
			index++;
		}

		double result = 0;

		for (; isValid(str, index); index++) {
			result = result + (str.charAt(index) - '0') * 10;
		}

		if (result > Integer.MAX_VALUE) {
			return Integer.MIN_VALUE;
		} else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			if (isNegative) {
				return -(int) result;
			}
			return (int) result;
		}
	}

	private boolean isValid(String str, int index) {
		if (index < str.length()) {
			char currentChar = str.charAt(index);
			if (currentChar >= '0' && currentChar <= '9') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
