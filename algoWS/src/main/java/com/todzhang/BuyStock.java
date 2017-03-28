package me.todzhang;

import java.util.Arrays;

/* 
 * this is dynamic programing
 *  * 
 */
public class BuyStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = { 25,  39, 9, 15,38, 5, 2, 7, 20, 24 };
		System.out.println("input price:" + Arrays.toString(prices));
		int profit = maxProfit(prices);
		System.out.println("max profit is:" + profit);
		profit=maxProfitAllowingMoreTransactions(prices);
		System.out.println("max profit is (allow multiple transactions):"+profit);
		System.out.println("===== with two transactions ===");
		profit=maxProfitBuySellStockWithTwoTransactions(prices);
		System.out.println("max profit is (with two transactions):"+profit);

	}

	private static int maxProfit(int[] input) {
		if (input.length <= 1)
			return 0;

		int minPrice = input[0];
		int profit = input[1] - minPrice;

		for (int i = 2; i < input.length; i++) {
			minPrice = Math.min(minPrice, input[i - 1]);
			System.out.println("-- min prices is :"+minPrice);
			profit = Math.max(profit, input[i] - minPrice);
		}
		System.out.println("-- last min price is:" + minPrice);
		return profit;
	}
	
	/*
	 * allow multiple transactions to get max profit
	 * Best Time to Buy and Sell Stock II
Say you have an array for which the ith element 
is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time 
 (ie, you must sell the stock before you buy again).

	 */
	private static int maxProfitAllowingMoreTransactions(int[] input){
		if(input.length<=1)
			return 0;
		
		int sum=0;
		for (int i = 1; i < input.length; i++) {
			if(input[i]>input[i-1])
			{
				System.out.println(String.format("-- adding (%d - %d) = %d and sum is %d",input[i],input[i-1],(input[i]-input[i-1]),sum));
				sum+=input[i]-input[i-1];
			}			
		}
		return sum;
	}
	
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
这题是三道题目中最难的一题,只允许两次股票交易,如果只允许一次,那么题目就退化到第一题了,根据第一题的算法,我们可以得到[0,1,...,i]区间的最大利润,同时在从后往前扫描得到[i,i+1,...,n-1]的最大利润,两个相加就可以得到该题的解了。

	 */
	private static int maxProfitBuySellStockWithTwoTransactions(int[] input){
		if(input.length<=1)
			return 0;
		int[] profits=new int[input.length];
		
//		int[] prices = { 25,  39, 9, 15,38, 5, 2, 7, 20, 24 };
		
		//首先我们正向遍历得到每天一次交易的最大收益 
		//并保存到profits里面
		int minPrice=input[0];
		int sum=Integer.MIN_VALUE;
		for (int i = 1; i < input.length; i++) {
			minPrice=Math.min(minPrice, input[i-1]);
			profits[i]=Math.max(sum, input[i]-minPrice);			
			sum=profits[i];
		}
		
		int maxPrice=input[input.length-1];
		int sum2=Integer.MIN_VALUE;
		for (int i = input.length-2; i >=0; i--) {
			maxPrice=Math.max(maxPrice, input[i+1]);
			sum2=Math.max(sum2, maxPrice-input[i]);
			if(sum2>0){
				profits[i]+=sum2;
				sum=Math.max(sum, profits[i]);
			}			
		}
		
		return sum>0?sum:0;
		
	}

}
