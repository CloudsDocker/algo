package me.todzhang;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("===== start processing ====");
		String str1="BCDE";
		String str2="CGD";
		
		System.out.println("--- naiive approach---time complexity is expoteninal");
		System.out.println("---:"+editDistanceNaiveApproach(str1,str2,str1.length(),str2.length()));
		
		System.out.println("--- recursive approach---");
		System.out.println("----2:"+editDistDP(str1, str2, str1.length(), str2.length()));
		
		
//		String str1="BCDE";
//		String str2="CGD";
		
		int[][] mat=getEditDistance(str1, str2);
		System.out.println("--- the edit distance is:"+mat[str1.length()-1][str2.length()-1]);
	}
	
	
	private static int editDistanceNaiveApproach(String s1,String s2, int m, int n){
		//base case
		if(m==0){
			// if first character is empty, just insert all chacters of of s2
			return n;
		}
		if(n==0){
			return m;
		}
		char c1=s1.charAt(m-1);
		char c2=s2.charAt(n-1);
		if(c1==c2){
			// last character are same, then return remaining characters
			return editDistanceNaiveApproach(s1, s2, m-1, n-1);
		}
		
		// if last character is different, then recurisvely compute minium cost for all three operations and 
		// take the minum approach
		return 1+min(editDistanceNaiveApproach(s1, s2, m-1, n-1), // replace
				editDistanceNaiveApproach(s1, s2, m-1, n), // remove
				editDistanceNaiveApproach(s1, s2, m, n-1) // insert
				);
	}
	
	private static int min(int x, int y, int z){
//		return x<y && x<z?x:(y<x&&y<z?y:z);
		if (x<y && x<z) return x;
        if (y<x && y<z) return y;
        else return z;
	}
	
	//https://www.youtube.com/watch?v=We3YDTzNXEk
	//Time Complexity: O(m x n)
	//Auxiliary Space: O(m x n)
	static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m+1][n+1];
      
        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j
      
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i
      
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
      
                // If last character are different, consider all
                // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                       dp[i-1][j],  // Remove
                                       dp[i-1][j-1]); // Replace
            }
        }
  
        return dp[m][n];
    }

	/***
	 * Dynamic Programming
Dynamic Programming is a variation on Divide and Conquer that solves a problem by subdividing it into a number of simpler subproblems that are solved in a specific order. It solves each smaller problem just once and stores the results for future use to avoid unnecessary recomputation. It then solves problems of increasing size, composing together solutions from the results of these smaller subproblems. In many cases, the computed solution is provably optimal for the problem being solved.
Dynamic Programming is frequently used for optimization problems where the goal is to minimize or maximize a particular computation. The best way to explain Dynamic Programming is to show a working example.
Scientists often compare DNA sequences to determine their similarities. If you rep‐ resent such a DNA sequence as a string of characters—A, C, T, or G—then the problem is restated as computing the minimum edit distance between two strings. That is, given a base string s1 and a target string s2 determine the fewest number of edit operations that transform s1 into s2 if you can:
·	Replace a character in s1 with a different character
·	Remove a character in s1
·	Insert a character into s1
For example, given a base string, s1, representing the DNA sequence “GCTAC” you only need three edit operations to convert this to the target string, s2, whose value is “CTCA”:
·	Replace the fourth character (“A”) with a “C”
·	Remove the first character (“G”)
·	Replace the last “C” character with an “A”
This is not the only such sequence of operations, but you need at least three edit operations to convert s1 to s2. For starters, the goal is to compute the value of the optimum answer—i.e., the number of edit operations—rather than the actual sequence of operations.
Dynamic Programming works by storing the results of simpler subproblems; in this example, you can use a two-dimensional matrix, m[i][j], to record the result of computing the minimum edit distance between the first i characters of s1 and the first j characters of s2. Start by constructing the following initial matrix:
0 1 2 3 4
1	.	.	.	.
2	.	.	.	.
 
3	.	.	.	.
4	.	.	.	.
5	.	.	.	.
In this table, each row is indexed by i and each column is indexed by j. Upon com‐ pletion, the entry m[0][4] (the top-right corner of the table) will contain the result of the edit distance between the first 0 characters of s1 (i.e., the empty string “”) and the first four characters of s2 (i.e., the whole string “CTCA”). The value of m[0][4] is 4 because you have to insert four characters to the empty string to equal s2. Simi‐ larly, m[3][0] is 3 because starting from the first three characters of s1 (i.e., “GCT”) you have to delete three characters to equal the first zero characters of s2 (i.e., the empty string “”).
The trick in Dynamic Programming is an optimization loop that shows how to compose the results of these subproblems to solve larger ones. Consider the value of m[1][1], which represents the edit distance between the first character of s1 (“G”) and the first character of s2 (“C”). There are three choices:
·	Replace the “G” character with a “C” for a cost of 1
·	Remove the “G” and insert the “C” for a cost of 2
·	Insert a “C” character and then delete the “G” character for a cost of 2
You clearly want to record the minimum cost of each of these three choices, so m[1] [1] = 1. How can you generalize this decision? Consider the computation shown in Figure 3-2.
These three options for computing m[i][j] represent the following:
Replace cost
Compute the edit distance between the first i – 1 characters of s1 and the first j – 1 characters of s2 and then add 1 for replacing the jth character of s2 with the ith character of s1, if they are different.
Remove cost
Compute the edit distance between the first i – 1 characters of s1 and the first j characters of s2 and then add 1 for removing the ith character of s1.
Insert cost
Compute the edit distance between the first i characters of s1 and the first j – 1 characters of s2 and then add 1 for inserting the jth character of s2.
Visualizing this computation, you should see that Dynamic Programming must evaluate the subproblems in the proper order (i.e., from top row to bottom row, and left to right within each row, as shown in Example 3-3). The computation proceeds from row index value i = 1 to len(s1). Once the matrix m is populated with its initial
 
values, a nested for loop computes the minimum value for each of the subproblems in order until all values in m are computed. This process is not recursive, but rather, it uses results of past computations for smaller problems. The result of the full prob‐ lem is found in m[len(s1)][len(s2)].
 
Figure 3-2. Computing m[i][j]
Example 3-3. Minimum edit distance solved using Dynamic Programming
def m1.nEd1.tD1.stance(s1, s2):
"""Compute minimum edit distance converting s1 -> s2."""
len1 = len(s1)
len2 = len(s2)
# Create two-dimensional structure such that m[i][j] = 0
# for i in 0 .. len1 and for j in 0 .. len2
m = [None] * (len1 + 1)
for 1. in range(len1+1):
m[1.] = [0] * (len2+1)
# set up initial costs on horizontal and vertical
for 1. in range(1, len1+1):
m[1.][0] = 1.
for j in range(1, len2+1):
m[0][j] = j
# compute best
for 1. in range(1,len1+1): for j in range(1,len2+1):
cost = 1
 
if s1[i-1] == s2[j-1]: cost = 0
replaceCost = m[i-1][j-1] + cost removeCost = m[i-1][j] + 1 insertCost = m[i][j-1] + 1
m[i][j]	= min(replaceCost,removeCost,insertCost)
return m[len1][len2]
Table 3-5 shows the final value of m. Table 3-5. Result of all subproblems
0	1	2	3	4
1	1	2	3	4
2	1	2	2	3
3	2	1	2	3
4	3	2	2	2
5	4	3	2	3

The cost of subproblem m[3][2] = 1 which is the edit distance of the string “GCT” and “CT”. As you can see, you only need to delete the first character which validates this cost is correct. This code only shows how to compute the minimum edit dis‐ tance; to actually record the sequence of operations that would be performed, a prev[i][j] matrix records which of the three cases was selected when computing the minimum value of m[i][j]. To recover the operations, trace backwards from m[len(s1)][len(s2)] using decisions recorded in prev[i][j] stopping once m[0][0] is
reached. This revised implementation is shown in Example 3-4.
Example 3-4. Minimum edit distance with operations solved using Dynamic Programming
REPLACE = 0 REMOVE = 1 INSERT = 2
def minEditDistance(s1, s2):
"""Compute minimum edit distance converting s1 -> s2 with operations."""
len1 = len(s1)
len2 = len(s2)
# Create two-dimensional structure such that m[i][j] = 0
# for i in 0 .. len1 and for j in 0 .. len2
m = [None] * (len1 + 1)
op = [None] * (len1 + 1)
for i in range(len1+1):
 
m[i] = [0] * (len2+1) op[i] = [-1] * (len2+1)
# set up initial costs on horizontal and vertical
for j in range(1, len2+1):
m[0][j] = j
for i in range(1, len1+1):
m[i][0] = i
# compute best
for i in range(1,len1+1):
for j in range(1,len2+1):
cost = 1
if s1[i-1] == s2[j-1]: cost = 0
replaceCost = m[i-1][j-1] + cost removeCost = m[i-1][j] + 1 insertCost = m[i][j-1] + 1
costs	= [replaceCost,removeCost,insertCost]
m[i][j]	= min(costs)
op[i][j]	= costs.index(m[i][j])
ops = []
i = len1
j = len2
while i != 0 or j != 0:
if op[i][j] == REMOVE or j == 0:
ops.append('remove {}-th char {} of {}'.format(i,s1[i-1],s1))
i = i-1
elif op[i][j] == INSERT or i == 0:
ops.append('insert {}-th char {} of {}'.format(j,s2[j-1],s2))
j = j-1
else:
if m[i-1][j-1] < m[i][j]:
fmt='replace {}-th char of {} ({}) with {}' ops.append(fmt.format(i,s1,s1[i-1],s2[j-1])) i,j = i-1,j-1
return m[len1][len2], ops

	 * @return
	 */
	private static int[][] getEditDistance(String s1, String s2){
		
		int len1=s1.length();
		int len2=s2.length();
		int[][] matrix=new int[len1+1][len2+1];
		
		// init values for edge cases
		
		// i'th chars to zero j will take i'th deletion
		for (int i = 0; i <= len1; i++) {
			matrix[i][0]=i;			
		}
		
		// empty string (str1) to i'th s2, take i'th insertion
		for(int j=0;j<=len2;j++){
			matrix[0][j]=j;
		}
		
		// other ordinary cases
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				int repCost=1;
				
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					// same character, no need replace
					repCost=0;
				}
				
				
				//get various costs
				int replaceCost=matrix[i-1][j-1]+repCost;
				int deleteCost=matrix[i-1][j]+1;
				int insertCost=matrix[i][j-1]+1;
				
				int min=Math.min(Math.min(replaceCost, insertCost), deleteCost);
				matrix[i][j]=min;
//				String str1="BCDE";
//				String str2="CGD";
				if(replaceCost<deleteCost && replaceCost<insertCost){
					System.out.println(String.format("--- replaced --%s with %s in %s",s1.charAt(i-1),s2.charAt(j-1),s1));					
				}
				else if(deleteCost<replaceCost && deleteCost<insertCost){
					System.out.println(String.format("--- removed--%s in %s",s1.charAt(i-1),s1));					
				}
				else if(insertCost<replaceCost && insertCost<deleteCost){
					System.out.println(String.format("--- inserted --%s in %s",s2.charAt(j-1),s2));					
				}

			}
			
		}
		return matrix;
		
	}
}
