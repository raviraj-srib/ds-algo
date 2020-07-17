package practice.string;

import java.util.HashMap;

public class AnagramUsingMap {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length() ){
        	return false;
        }
        
        HashMap<Character, Integer> dataMap = new HashMap<Character, Integer>();
        char currentChar;
        //Adding S to map
        for (int i = 0, size = s.length() ; i <size; i++) {
        	currentChar = s.charAt(i);
        	if (dataMap.containsKey(currentChar)) {
        		int count = dataMap.get(currentChar);
        		dataMap.put(currentChar, count + 1);
        	} else {
        		dataMap.put(currentChar, 1);
        	}
        }
        
        //Removing from map using t
        for (int i = 0, size = t.length() ; i <size; i++) {
        	currentChar = t.charAt(i);
        	if (dataMap.containsKey(currentChar)) {
        		int count = dataMap.get(currentChar);
        		if(count == 1) {
        			dataMap.remove(currentChar);
        		} else {
        			dataMap.put(currentChar, count - 1);
        		}
        	} else {
        		return false;
        	}
        }
       return dataMap.size() == 0; 
    }
}
