package me.todzhang;



import java.util.HashMap;
import java.util.Map;

/**
 * 
 iven an array of intergers, find two numbers such that they add up to a specific target number. The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2 Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2

 * 
 * 
 * logic is : if use brute force, it will be power of n, which is last option
 * to optimize, e.g. to O(n) or O(1), the hasb_map look up is O(1)
 */
public class TwoSum {
	
	public static void main(String[] args) {
		System.out.println("=== Start ====");
		int[] a = new int[] { 7,2,4, 9,11,15 };
		

		System.out.println("array a is :" + java.util.Arrays.toString(a));

		System.out.println("the result is :"
				+ java.util.Arrays.toString(getTwoSum(a,9)));
	}

	private static int[] getTwoSum(int[] a, int total) {
		int[] result=new int[2];
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<a.length;i++){
			map.put(a[i],i);
		}
		
		for(int i=0;i<a.length;i++){
			int remaining=total-a[i];
			if(map.containsKey(remaining)){
				/*
				 * 
				 * below are highlights and bonus
				 */
				
				if(map.get(remaining)==i){
					//same element, skip
					continue;
				}
				
				
				
				// below are normal logic
				result[0]=i+1;
				result[1]=map.get(remaining)+1;
				
				// the question is the index should be incremental
				if(result[0]>result[1]){
					// swap the index
					result[0]=result[0] ^ result[1];
					result[1]=result[0]^result[1];
					result[0]=result[0]^result[1];
				}
				System.out.println(String.format("---- get result of %d at %d and %d at %d",a[i],i,remaining,map.get(remaining)));
			}
		}
		
		return result;
	}

}
