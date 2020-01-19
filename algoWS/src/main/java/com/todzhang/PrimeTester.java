public class PrimeTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("=====1. naive approach ===");
		for (int i = 1; i < 15; i++) {
			System.out.println(i + " is prime? : "+ isPrimeNaive(i));
			
		}
		
		System.out.println("=====2. power of 2 approach ===");
		for (int i = 1; i < 15; i++) {
			System.out.println(i + " is prime? : "+ isPrimeEven(i));
			
		}
	
		System.out.println("=====3. isPrimeSquare approach ===");
		for (int i = 1; i < 15; i++) {
			System.out.println(i + " is prime? : "+ isPrimeSquare(i));
			
		}
		
	}
	/**
	 * We learned numbers are prime if the only divisors they have are 1 and itself. Trivially, 
	 * we can check every integer from 1 to itself (exclusive) 
	 * and test whether it divides evenly.
	 * @param n
	 * @return
	 */
	private static boolean isPrimeNaive(int n){
		for (int i = 2; i < n; i++) {
			System.out.println("-- innert loop");
			if(n%i==0){
				return false;
			}			
		}
		return true;
	}
	
	/**
	 * further enhance, as if 2 divides some interger n, then (n/2) divides n as well
	 * so we'll times of 2.
	 * Please be advised in for loop, should use 2*i<=n, rather than "<n", 
	 * otherwise, 4 will be return as ture mistakely
	 * @param n
	 * @return
	 */
	private static boolean isPrimeEven(int n){
		for(int i=2;2*i<=n;i++){
			System.out.println("-- innert loop");
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	/**
	 *  we notice that you really only have to go up to the square root of n, 
	 *  because if you list out all of the factors of a number, 
	 *  the square root will always be in the middle
	 *  
	 *  Finally, we know 2 is the "oddest" prime - it happens to be the only even prime number.
	 *   Because of this, we need only check 2 separately, then traverse
	 *    odd numbers up to the square root of n. 
	 *    In the end, our code will resemble this:
	 * @param n
	 * @return
	 */
	private static boolean isPrimeSquare(int n){
		// check if n is a multiple of n
		if(n>2&&n%2==0)
			return false;
		
		// if not, then just check the odds
		for(int i=3;i*i<=n;i+=2){
			if(n%i==0) 
				return false;			
		}
		return true;
	}

}
