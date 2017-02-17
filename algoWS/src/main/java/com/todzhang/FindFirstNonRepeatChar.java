package com.todzhang;

import java.util.*;
import java.lang.Character;

public class FindFirstNonRepeatChar{

   public static void main(String[] args){
        System.out.println("==== start ===");
		System.out.println("==== the first non-repeat characters : "+findFirstNonRepeatChar("aasssueeessgg"));
		System.out.println("==== the first non-repeat characters [enhanced version] : "+findFirstNonRepeatChar2("aasssueeessgg"));
   }


     private static Character findFirstNonRepeatChar(String input){
		Map<Character,Integer> charCounts=new LinkedHashMap<Character,Integer>();
		// save each element to hash table
		for(int i=0;i<input.length();i++){
			if(!charCounts.containsKey(input.charAt(i))){
				charCounts.put(input.charAt(i),0);
			}
			charCounts.put(input.charAt(i),charCounts.get(input.charAt(i))+1);
		}
		
		// to find the first non repeat character
		for(Character theChar: charCounts.keySet()){
			if(charCounts.get(theChar)<2){
				return theChar;
			}
		}
		return null;
     }
	 enum COUNT{
		SINGLE,MULTIPLE
	 }
	 // Better solution, as the initial solution has some performance enhancement room
	 // such as the map keep Integer need to be created, discarded each time
	 // but it's only have two state, single or more than one
	  private static Character findFirstNonRepeatChar2(String input){
		Map<Character,COUNT> charCounts=new LinkedHashMap<Character,COUNT>();
		// save each element to hash table
		for(int i=0;i<input.length();i++){
			if(!charCounts.containsKey(input.charAt(i))){
				charCounts.put(input.charAt(i),COUNT.SINGLE);
			}
			else{
				charCounts.put(input.charAt(i),COUNT.MULTIPLE);
			}
		}
		
		// to find the first non repeat character
		for(Character theChar: charCounts.keySet()){
			if(charCounts.get(theChar)==COUNT.SINGLE){
				return theChar;
			}
		}
		return null;
     }
}