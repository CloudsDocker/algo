package me.todzhang;

import java.util.Arrays;

/**
 * 
 * Merge Sorted Array Given two sorted integer arrays A and B, merge B into A as
 * one sorted array. Note: You may assume that A has enough space (size that is
 * greater or equal to m + n) to hold additional elements from B. The number of
 * elements initialized in A and B are m and n respectively.
 * 
 * 
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		System.out.println("=== Start ====");
		int[] a = new int[] { 4, 9 };
		int[] b = new int[] { 3, 6, 9 };
		int m = a.length;
		int n = b.length;
		a = Arrays.copyOf(a, m + n);

		System.out.println("array a is :" + java.util.Arrays.toString(a));
		System.out.println("array b is :" + java.util.Arrays.toString(b));
		System.out.println("the result is :"
				+ java.util.Arrays.toString(MergeSortedArray(a, b, m, n)));
		System.out.println("=== mergeArray2 ====");
		int[] aryA = new int[] { 1, 3, 5, 7, 9 };
		int[] aryB = new int[] { 2, 4, 6, 8, 10, 12, 14 };
		int[] aryC = mergeArray2(aryA, aryB);
		System.out.println(" the result array is:" + Arrays.toString(aryC));
	}

	private static int[] MergeSortedArray(int[] a, int[] b, int m, int n) {
		// int[] a=new int[]{1,9};
		// int[] b=new int[]{3,9};
		int pos = m + n - 1;
		int i = m - 1, j = n - 1;
		while (pos >= 0) {
			if (i >= 0 && j >= 0) {
				//both two arays not exhasited
				if (a[i] > b[j]) {
					a[pos] = a[i];
					--i;
				} else {
					a[pos] = b[j];
					--j;
				}
			} else if (i >= 0) {
				// only first array, while second array exhasted
				a[pos] = a[i];
				--i;
			} else if (j >= 0) {
				// only second array exist, while first array exhasted
				a[pos] = b[j];
				--j;
			}

			pos--;
		}
		return a;
	}

	// the first thing is no aditional array data structure not allowed
	// when scan from begining of A, insert element from B to A, need to move
	// all the element after cursor

	// so the better logic is: reverse it, e.g. from end to begining.
	private static int[] MergeSortedArrayMimeNot(int[] a, int[] b, int m, int n) {
		// int[] a=new int[]{1,9};
		// int[] b=new int[]{3,9};
		int pos = m + n - 1;
		int i = m - 1, j = n - 1;
		while (pos >= 0) {
			if (a[i] > b[j]) {
				a[pos] = a[i];
				if (i > 0) {
					--i;
				}
			} else {
				a[pos] = b[j];
				if (j > 0) {
					--j;
				}
			}
			pos--;
		}
		return a;
	}

	private static int[] mergeArray2(int[] a, int[] b) {
		// the logic is compare both a and b from tail, as those two arrays
		// already been sorted
		// find who is bigger, pick it and appended to the tail of c
		int nA = a.length - 1;
		int nB = b.length - 1;
		int[] aryC = new int[a.length + b.length];

		for (int i = (a.length + b.length) - 1; i >= 0; i--) {
			if (nA >= 0 && nB >= 0) {
				if (a[nA] > b[nB]) {
					aryC[i] = a[nA];
					--nA;
				} else {
					aryC[i] = b[nB];
					--nB;
				}
			} else if (nA >= 0) {
				// means done traverse of aryB
				aryC[i] = a[nA];
				--nA;
			} else if (nB >= 0) {
				// means done traverse of aryA
				aryC[i] = b[nB];
				--nB;
			}
			// --i;
		}

		return aryC;
	}

}
