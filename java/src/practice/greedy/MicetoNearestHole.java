package practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MicetoNearestHole {
	
	

	public static void main(String[] args) {
		ArrayList<Integer> micePosArr = new ArrayList<Integer>(Arrays.asList(35, 72, -95, -54, 89, 5, 23, 13, 38, 20, 66, 26, 63, 44, -50, -23, -85, -72, -47, -96));
		ArrayList<Integer> holePosArr = new ArrayList<Integer>(Arrays.asList(24, 45, -36, 26, -43, 80, -45, 19, -93, -92, -70, -54, -63, -9, -62, 36, 96, -68, -75, -57));
		int cost = mice(micePosArr,holePosArr);

		System.out.println(cost);
	}

	public static int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
		int maxCost = 0;
		HashSet<Integer> holesPosSet = new HashSet<>(holes);
		Collections.sort(mice);
		System.out.println(holesPosSet);
		for (int i = 0; i < mice.size(); i++ ) {
			int micePos = mice.get(0);
			System.out.println("Processing mouse : " + micePos + "  HashSetSize : " +holesPosSet.size() + " HashSet  : " + holesPosSet );
			if (!holesPosSet.contains(micePos)) {
				int cost = getCost(micePos, holesPosSet);
				if (cost > maxCost) {
					maxCost = cost;
				}
			} else {
				holesPosSet.remove(micePos);
			}
		}

		return maxCost;
	}

	private static int getCost(int micePos, HashSet<Integer> holesPosSet) {
		int offset = 0;
		boolean isFound = false;
		while (!isFound) {
			offset++;
			if (holesPosSet.contains(micePos + offset)) {
				isFound = true;
				holesPosSet.remove(micePos + offset);
			} else if (holesPosSet.contains(micePos - offset)) {
				isFound = true;
				holesPosSet.remove(micePos - offset);
			}
		}

		return offset;
	}

}
