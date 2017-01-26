package com.todzhang;

public class BinarySearch{
	public static void main(String[] args){
		System.out.println("=============start==========");
		int[] data=new int[]{1,3,5,6,7,8,9,10,15};
		System.out.println("found?:"+ binarySearch(data,4,0,data.length));
	}
	
	// this approach will take O(logn), better than linear search, which is O(n)
	public static boolean binarySearch(int[] data,int target,int low, int high){
		if(low>high)
			return false;
		else{
			int mid=(high+low)/2; //median candidate
			if(target==data[mid])
				return true;
			else if(target<data[mid])
				return binarySearch(data,target,low,mid-1);
			else
				return binarySearch(data,target,mid+1,high);
		}
			
	}
}
