package com.todzhang;

import java.util.Arrays;

public class RemoveChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// the naiive approach is O(n * n)
	// the optimized approach is O(n), by using Array search is O(1)
	private static void removeChars(String input, String rmv){
		// in case checked with question asker the char possibility is ASCII
		boolean[] flags=new boolean[128];
		// using Arrays.fill to set all flase
		Arrays.fill(flags, false);
	}
}
