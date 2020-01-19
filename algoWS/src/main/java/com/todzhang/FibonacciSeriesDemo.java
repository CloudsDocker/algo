public class FibonacciSeriesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("========== iterative approach============");
		iterative(10);
		System.out.println("========== recursive approach============");
		recursive(10);
		
		System.out.println("========== recursiveWithoutAdditionalVariables approach============");
		// without additional variable, but need one extra forloop
		// at the meanwhile, it will more loops
		for (int i = 1; i <= 10; i++) {
			System.out.println(recursiveWithoutAdditionalVariables(i)+",");			
		}
		
	}
	
	// using iterative apprach, rather than recursive
	private static void iterative(int count){
		// basic idea is create two additional variables
		int n1=0,n2=1,n3;
		System.out.print("0,1,");
		for (int i = 0; i < count; i++) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+",");
		}
	}
	
	static int n1=0,n2=1,n3=0;
	private static void recursive(int count){
		if(count-->0){
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.println(n3);
			recursive(count);
		}
	}

	
	private static int recursiveWithoutAdditionalVariables(int number){
		if(number <=2){
			return 1;
		}
		return recursiveWithoutAdditionalVariables(number-1)+recursiveWithoutAdditionalVariables(number-2);
		
		
	}
}
