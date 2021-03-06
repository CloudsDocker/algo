import static java.lang.System.out;

public class ReverseWords {
	public static void main(String[] args){
		out.println("==== start ===");
		char[] ary="hello world".toCharArray();
		reverse(ary,0,ary.length-1);
		out.println(" 1. after revers of 'hello world':"+new String(ary));
		reverseEachWords(ary);
		out.println(" 2. further reverse each word:"+new String(ary));
		SecurityManager
	}
	
	
	// reverse the whole string
	private static void reverse(char[] ary,int start,int end){
		//char[] ary=input.toCharArray();
		//int start=0,end=ary.length-1;
		while(start<end){
			ary[start]=(char)(ary[start]^ary[end]);
			ary[end]=(char)(ary[start]^ary[end]);
			ary[start]=(char)(ary[start]^ary[end]);	
			++start;
			--end;
		}
		//return ary;
	}
	
	private static void reverseEachWords(char[] ary){
		//char[] ary=input.toCharArray();
		int start=0,end=0;
		int len=ary.length;
		while(end<len){
			if(ary[end]!=' '){
				// non space, save position of the begining of word
				start=end;
				// scan to next non-word character
				while(end<len && ary[end]!=' '){
					end++;
				}
				// end of loop, backward one position
				end--;
				// reverse the word
				reverse(ary,start,end);
			}
			end++; //advance one postion of the space
		}
		//return new String(ary);
	}
}
