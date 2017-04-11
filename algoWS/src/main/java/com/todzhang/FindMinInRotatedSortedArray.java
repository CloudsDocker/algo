package me.todzhang;

/*
 * Find Minimum in Rotated Sorted Array
 Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 You may assume no duplicate exists in the array.
 */
public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println("=== start ===");
		//int[] ary = new int[] { 4, 5, 6, 7, 8, 1, 2 };
		int[] ary = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println("---- the smallest value is:"
				+ findMinMyOwn(ary, 0, ary.length - 1));
		
		System.out.println("--- find smallest via iterative: "+findMinIterative(ary));

		// int min=Integer.MIN_VALUE;
	}

	// use approach of divide-and-conqure
	private static int findMinMyOwn(int[] a, int start, int end) {
		if (end == start)
			return a[start];
		int mid = start + (end - start) / 2;
		if(mid==start){
			return Math.min(a[start], a[end]);
		}
		if (a[mid] > a[start]) {
			// the smallest in right part
			return findMinMyOwn(a, mid, end);
		} else if(a[mid]<a[start]){
			return findMinMyOwn(a, start, mid);
		} else{
			return findMinMyOwn(a,mid,mid);
		}

	}
	
	// use iterative, isntead of recursive
	// i.e. replace sell call with while loop
	private static int findMinIterative(int[] a){
		
		int start=0;
		int end=a.length-1;
		int rtn=-1;
		
		
		while(start<end-1){
			if(a[start]<a[end]){
				return a[start];
			}
			
			int mid=start+(end-start)/2;
			if(a[mid]>a[start]){
				start=mid;
			}
			else if(a[mid]<a[start]){
				end=mid;
			}
		}
		return Math.min(a[start],a[end]);
	}

}
