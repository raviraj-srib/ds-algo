package practice.string;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			char startChar = s.charAt(start);
			char endChar = s.charAt(end);
			if (isSkipChar(startChar) && isSkipChar(endChar)) {
				start++;
				end--;
			} else if (isSkipChar(startChar)) {
				start++;
			} else if (isSkipChar(endChar)) {
				end--;
			} else {
				startChar = Character.toLowerCase(startChar);
				endChar = Character.toLowerCase(endChar);

				if (startChar != endChar) {
					return false;
				}
				start++;
				end--;
			}
		}

		return true;

	}

	private boolean isSkipChar(char startChar) {
		if (Character.isAlphabetic(startChar) || Character.isDigit(startChar)) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		String data = "A man, a plan, a canal: Panama";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(data));
		
	}
}
