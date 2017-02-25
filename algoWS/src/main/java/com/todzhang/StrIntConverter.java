package com.todzhang;

public class StrIntConverter {
	public static void main(String[] args){
		System.out.println("==== start ===");
		System.out.println("--- return of 732 is:"+strToInt("732"));
		System.out.println("--- return of -659 is:"+strToInt("-659"));
	}
	
	// input is as "732", the output should be a int 732
	// if input is "-732", the output is int -732
	private static int strToInt(String input){
		int num=0;
		char[] ary=input.toCharArray();
		boolean isNeg=false;
		int idx=0, len=ary.length;
		
		if(ary[0]=='-'){
			isNeg=true;
			idx=1;
		}
		
		while(idx<len){
			num*=10;
			// **** the "- '0'" is important, otherwise the result is incorrect
			num+=(ary[idx++]-'0');
		}
		
		if(isNeg){
			num*=-1;
		}
		
		return num;
	}
}
