
package practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllAnagram {
	public static void main(String[] args) {
	//	System.out.println("Print");
		System.out.println(getAllAnagrams("abab","ab"));
	}

	private static ArrayList<Integer> getAllAnagrams(String s, String p)  {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		Map<Character,Integer> patternMap = new HashMap<Character, Integer>();
		for(int i = 0, size = p.length(); i < size; i++) {
			Character c = p.charAt(i);
		 if( patternMap.containsKey(c) ){
			 int count = patternMap.get(c);
			 patternMap.put(c, count + 1);
		 }
		 else {
			 patternMap.put(c, 1);
		 }
		}
		
		
		for(int i =0, size = s.length(); i < size; i++ ) {
			if (isAnagramPossible(s.substring(i), new HashMap<>(patternMap))) {
				indexList.add(i);
			}
		}
		return indexList;
		
	}

	private static boolean isAnagramPossible(String s,  HashMap<Character, Integer> map) {
		//System.out.println("MAP : "+ map);
		for (int i =0, size= s.length(); i < size; i++) {
			if (map.size() == 0) {
				return true;
			}
			if(map.containsKey(s.charAt(i))) {
				map.remove(s.charAt(i));
			} else {
				return false;
			}
		}
		return map.size() == 0;
	}
}
