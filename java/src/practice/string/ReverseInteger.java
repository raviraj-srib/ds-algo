package practice.string;

public class ReverseInteger {
    public int reverse(int x) {
    	boolean iSNegative = false;
    	if( x < 0 ){
    		iSNegative = true;
    		x = x * -1;
    	}
    	
    	char stringNumber[] = String.valueOf(x).toCharArray();
    	reverseString(stringNumber);
    	int num =Integer.parseInt(stringNumber.toString());
    	return num;
    	
    }
    
    
    public void reverseString(char[] s) {
        int end = s.length - 1;
        int start = 0;
        char temp;
        while (start < end) {
        	 temp = s[start];
        	 s[start] =  s[end];
        	 s[end] = temp;
        	 start++;
        	 end--;
        }
    }
}
