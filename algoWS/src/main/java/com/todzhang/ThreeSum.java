package me.todzhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("============== start ===========");
		int[] data = new int[] { 9, -4, -1, 7, 5 };
		System.out.println("the result is:"
				+ Arrays.toString(getThreeSum(data)));
	}

	private static int[] getThreeSum(int[] ary) {
		int[] rtn = new int[3];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < ary.length; i++) {
			map.put( ary[i],i);
		}

		for (int i = 0; i < ary.length; i++) {
			// int j = ary[i];
			int remains = 0 - ary[i];

			for (int j = 0; j < ary.length; j++) {
				if (i != j) {
					int remainsOthers = remains - ary[j];
					if (map.containsKey(remainsOthers)) {
						int k=map.get(remainsOthers);
						if(i!=j && j!=k){
							// found the result
							rtn[0] = i;
							rtn[1] = j;
							rtn[2] = map.get(remainsOthers);
							System.out
									.println(String
											.format("the result are at %d,%d,%d postions: %d,%d,%d",
													ary[i], ary[j],
													ary[k], i,
													j, rtn[2]));
						}
						
					}
				}

			}
		}
		Arrays.sort(rtn);
		return rtn;
	}

}
