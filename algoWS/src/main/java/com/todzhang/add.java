package com.todzhang;
public class add {
	// add in Java
	public static void add(int[] n1, int[] n2, int[] sum) {
		int position = n1.length - 1;
		int carry = 0;
		while (position >= 0) {
			int tmpSum = n1[position] + n2[position] + carry;
			sum[position + 1] = tmpSum % 10;
			if (tmpSum > 9) {
				carry = 1;
			} else {
				carry = 0;
			}
			--position;
		}
		sum[0] = carry;
	}
}
