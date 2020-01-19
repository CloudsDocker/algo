import java.util.Arrays;

public class FourSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c and d in S such that 
	 * a+b+c+d = target? Find all unique quadruplets in the array which gives
	 *  the sume of target.
Note:
1.	Elements in quadruplets (a, b, c, d) must be 
in non-descending order. (ie, a<=b<=c<=d)
2.	The solution must not contain duplicates quadruplets.

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary=new int[]{4,2,1,8,7,9};
		// need to sort the array
		Arrays.sort(ary);
		System.out.println("the return value is:"+Arrays.toString(doFourSum(ary, 18)));
	}

	private static int[] doFourSum(int[] ary, int target){
		int[] rtn=new int[4];
		
		if(ary.length<3){
			return rtn;
		}
		
		for (int i = 0; i < rtn.length-3; i++) {
			if(i>0 && ary[i]==ary[i-1]){
				continue;
				// remove duplicate
			}
			
			for(int j=i+1;j<ary.length-2;++j){
				if(j>i+1 && ary[i]==ary[j-1]){
					continue;
				}
				
				int k=j+1;
				int l=ary.length-1;
				
				while(k<l){
					int sum=ary[i]+ary[j]+ary[k]+ary[l];
					
					if(sum==target){
						rtn[0]=ary[i];
						rtn[1]=ary[j];
						rtn[2]=ary[k];
						rtn[3]=ary[l];
						
						// found result, follwoing two loop to remove duplicate
						do{
							++k;
						}while(k<l && ary[k]==ary[k-1]);
						
						do{
							--l;
						}while (k<l && ary[l]==ary[l+1]);
						
					}
					else if (sum<target){
						// smaller than targer, increase
						++k;
					}
					else{
						--l;
					}
				}
			}
			
		}
		
		return rtn;
	}
}
