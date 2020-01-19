import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("======= start ============");
		int[] ary=new int[]{1,2,3,5,6,8,9};
		List<List<Integer>> rtn=kSumRecursive(2, ary, 4, 0);
		System.out.println("-- the result is :"+Arrays.deepToString(rtn.toArray()));
		System.out.println("=== using DP approach ===:"+kSumDPBest(ary, 2, 5));
		
	}

	
	private static List<List<Integer>> kSumRecursive(int length,int[] ary, int target, int beginIndex){
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		if(length==0)
		{
			if(target==0){
				// target is zero, then add a blank array
				result.add(new LinkedList<Integer>());
			}
			return result;
		}
		
		for(int i=beginIndex;i<ary.length-length+1;i++){
			if(i>beginIndex && ary[i]==ary[i-1]){
				continue;
			}
			
			// using DP, get the sub sum of previous array
			for(List<Integer> partial: kSumRecursive(length-1, ary, target-ary[i], beginIndex+1)){
				// if enter this block, means there are values, so add current element
				partial.add(0,ary[i]);
				result.add(partial);
			}
		}
		return result;
	}
	
	private static int kSumDPBest(int[] ary, int k, int target){
		int n=ary.length;
		int[][][] f=new int[n+1][k+1][target+1];
		for(int i=0;i<n+1;i++){
			// base case, always is '1'
			f[i][0][0]=1;
		}
		
		for(int i=0;i<=n;i++){
			for(int j=1;j<=k && j<=i;j++){
				for(int t=1;t<=target;t++){
					f[i][j][t]=0;
					if(t>=ary[i-1]){
						f[i][j][t]=f[i-1][j-1][t-ary[i-1]];
					}
					f[i][j][t]+=f[i-1][j][t];
				}
			}
		}
		System.out.println("-- the array is: "+Arrays.deepToString(f));
		return f[n][k][target];
	}
	
}
