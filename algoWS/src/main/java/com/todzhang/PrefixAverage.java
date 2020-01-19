import java.util.Arrays;

public class PrefixAverage {

	/**
	 * output is:
	 * input is :[1.0, 2.0, 3.0, 4.0, 5.0, 7.0, 10.0, 20.0, 30.0, 40.0]
	naiive approacl O(n*n), output is:[1.0, 1.5, 2.0, 2.5, 3.0, 3.6666666666666665, 4.571428571428571, 6.5, 9.11111111111111, 12.2]
	linear bette approacl O(n), output is:[1.0, 1.5, 2.0, 2.5, 3.0, 3.6666666666666665, 4.571428571428571, 6.5, 9.11111111111111, 12.2]
	 */
	public static void main(String[] args) {

		double[] res=new double[]{1,2,3,4,5,7,10,20,30,40};
		System.out.println("input is :"+Arrays.toString(res));
		System.out.println("naiive approacl O(n*n), output is:"+Arrays.toString(prefixAverage1(res)));
		System.out.println("linear bette approacl O(n), output is:"+Arrays.toString(prefixAverage2(res)));

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
	
	// previous implementation is O(n2), 
	// while below with enhancement, the result is linear O(n)
	// For greater efficiency, we can maintain the current prefix sum dynamically, 
	// effectively computing x0 + x1 + ··· + xj as total + xj, 
	// where value total is equal to the sum x0 + x1 + ··· + xj − 1, 
	// when computed by the previous pass of the loop over j.
	private static double[] prefixAverage2(double[] x){
		int n=x.length;
		double[] a =new double[n];
		double total=0;
		for (int i = 0; i < n; i++) {
			total += x[i];
			a[i]=total/(i+1);			
		}
		return a;
	}

}
