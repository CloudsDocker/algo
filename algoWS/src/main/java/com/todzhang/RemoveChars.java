import java.util.Arrays;

public class RemoveChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input="hello world!";
		String remove="eod";
		System.out.println(" === after remove ====:"+removeChars(input, remove));
		// output is :  === after remove ====:hll wrl!
	}

	
	// the naiive approach is O(n * n)
	// the optimized approach is O(n), by using Array search is O(1)
	private static String removeChars(String input, String rmv){
		// in case checked with question asker the char possibility is ASCII
		boolean[] flags=new boolean[128];
		// using Arrays.fill to set all flase
		Arrays.fill(flags, false);
		
		for(int i=0;i<rmv.length();i++){
		flags[(int)rmv.charAt(i)]=true;	
		}
		
		
		// here is another trick,
		// instead of arbitrially loop the array
		// use self-incremental end pointer
		int src=0,dst=0;
		int len=input.length(); 
		char[] s=input.toCharArray();
		//save the origional length now, as input array will be updated later, the length maybe changed.
		while(src<len){
			if(!flags[(int)s[src]]){
				s[dst++]=s[src];
			}
			src++;
		}
		return new String(s,0,dst);
	}
}
