public class StringCombination {
	 /**   * @param args  */
	 
	public static void main(String[] args)

}

	{  // TODO Auto-generated method stub  System.out.println("----start-----"); 
	 combine("abcd"); }  

	private static void combine(String str)
	{  int len=str.length();  char[] ary=str.toCharArray();  
	StringBuilder out=new StringBuilder();  doCombine(ary, out, len, 0);  
	System.out.println("1. the output is:"+out.toString()); } 

	private static void doCombine(char[] input,StringBuilder out,int length, int start){ 
		   for(int i=start;i<length;i++){
			   // append latest location   out.append(input[i]);  
			 // print every combination   System.out.println(out);    
			  // if current index is less than last position  
			 // recursive to call, with start index increase by 1   if(i<length-1){    doCombine(input, out, length, i+1);   } 
			     // then remove the last element   out.setLength(out.length()-1);  } }}
			
	}
}
