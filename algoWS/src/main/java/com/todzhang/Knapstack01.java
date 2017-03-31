package me.todzhang;

import java.util.Arrays;

public class Knapstack01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// the array should be sorted in asending order
		int[] weight=new int[]{1,2,3};
		int[] value=new int[]{6,10,15};
		int total=5;
		
		System.out.println("--weight is:"+Arrays.toString(weight));
		System.out.println("--value is:"+Arrays.toString(value));
		System.out.println("--total is:"+total);
		System.out.println("==== result of naiiveApproach is:"+naiiveRecursiveApproach(total, weight, value, value.length));
		
	}


	private static void myOwnApproach(int[] weight,int[] value,int total){
		// NOT WORKING
//		int[] weight=new int[]{1,3,2,4,6};
//		int[] value=new int[]{3,4,5,1,2};
//		int total=7;
		
		int totalValue=0;
		int maxWeight=0;
		for (int i = 0; i < value.length; i++) {
			int tmpWeight = weight[i]+maxWeight;
			if(tmpWeight>total){
				//exceed total
				continue;
			}
			else{
				totalValue+=value[i];
			}
			
		}
	}
	
	private static int max(int a, int b){
		return a>b?a:b;
	}
	private static int naiiveRecursiveApproach(int total,int[] weight,int[] value,int n){
		// base case
		if(n==0 || total==0){
			return 0;
		}
		
		// if Nth item is more than capacity,then this item can NOT included
		if(weight[n-1]>total){
			return naiiveRecursiveApproach(total,weight, value, n-1);
		}
		else{
			// return the maximum
			// two branches, include current element or NOT include current element, 
			// recursive get the value and then using MAX to select it.
			return max(value[n-1]+naiiveRecursiveApproach(total-weight[n-1],weight, value,  n-1),naiiveRecursiveApproach(total, weight, value, n-1));
		}	
		
	}
	
}
