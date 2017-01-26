package me.todzhang;

import java.util.Arrays;

public class PrefixAverage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double[] res=new double[]{1,2,3,4,5,7,10,20,30,40};
		System.out.println("input is :"+Arrays.toString(res));
		System.out.println("output is:"+Arrays.toString(prefixAverage1(res)));

	}
	
	// the overall performance is O(n2) i.e. O(n*n)
	private static double[] prefixAverage1(double[] x){
		int n=x.length; // this is O(1) due to Java save Array length at header of Array
		double[] a=new double[n]; // this O(n)
		// following is O(n2)
		for (int i = 0; i < n; i++) {
			double total=0;
			for (int j = 0; j <=i; j++) { // be awre it's <=, instead of "<"
				total+=x[j];				
			}
			a[i]=total/(i+1);			
		}
		return a;
	}

}
