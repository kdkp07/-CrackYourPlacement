// problem link : https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1#
class Solution
{
    public long helper(int n , int i , int j, long[][][] dp){
        if(i<0 || j<0 || i>=4 || j>=3 || (i==3 && j!=1 ) ) return 0;
        if(n==1) return 1;
        if(dp[n][i][j]>0) return dp[n][i][j];
        return dp[n][i][j] = helper(n-1,i-1,j,dp) + helper(n-1,i,j+1,dp) + helper(n-1,i+1,j,dp)
            + helper(n-1,i,j-1,dp) + helper(n-1,i,j,dp);
    }
	public long getCount(int N)
	{
		// Your code goes here
		long ans = 0;
		long[][][] dp = new long[N+1][4][3];
		for(int i = 0; i <4;i++){
		    for(int j = 0; j < 3; j++){
		        ans = ans + helper(N,i,j,dp);
		    }
		}
		return ans;
	}
}
