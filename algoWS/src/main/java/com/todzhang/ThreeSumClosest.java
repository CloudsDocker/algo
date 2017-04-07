package me.todzhang;

import java.util.Arrays;

public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ary=new int[]{4,2,1,8,5,6,7,9};
				// need to sort the array
				Arrays.sort(ary);
				System.out.println("the return value is:"+getThreeSumCloses(ary, 18));
	}


	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You man assume that each input would have exactly one solution.
	 * @param ary
	 * @return
	 */
	private static int getThreeSumCloses(int[] ary, int target){
		// use three pointers to get the cloest return values
		int ret=0;
		
		
		
		////first we suspect the distance between the sum and the target is the largest num
		int distance=Integer.MAX_VALUE;
		for (int i = 0; i < ary.length-2; i++) {
			int j = i+1;
			int k=ary.length-1;
			// two pointers loop from both begining and end of the sorted array
			
			while(j<k){
				int tmp_val=ary[i]+ary[j]+ary[k];
				if(tmp_val>target){
					// means k is bigger
					int tmp_distance=tmp_val-target;
					if(tmp_distance<distance){
						distance=tmp_distance;
						ret=tmp_val;
						System.out.println("--- k is bigger");
					}
					--k;
				}
				else if(tmp_val<target){
					// means j is smaller
					int tmp_distance=target-tmp_val;
					if(tmp_distance<distance){
						distance=tmp_distance;
						ret=tmp_val;
						System.out.println("--- j is smaller");
					}
					--k;
				}
				else{
					// means two values matched
					ret=tmp_val;
					System.out.println("---- matched-----");
					return ret;
				}
			}			
		}
		return ret;
		
	}
}
