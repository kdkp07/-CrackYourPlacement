// Problem link : https://leetcode.com/problems/knight-dialer
class Solution {
    private int mod= 1000000007;
    public int knightDialer(int n) {
        long ans =0 ;
        long[][][] dp = new long[n+1][4][3];
        for(int i = 0; i<4;i++){
            for(int j = 0; j<3;j++){
                ans = ( ans + helper(dp,i,j,n)) %mod;
            }
        }
        return (int)ans;
    }
    private long helper(long[][][] dp , int i , int j , int n ){
        if(i>=4 || j>=3 || i<0 || j<0 || (i==3 && j!=1)) return 0;
        if(n==1) return 1;
        if(dp[n][i][j]>0) return dp[n][i][j];
        return dp[n][i][j] = helper(dp,i-1,j+2,n-1)%mod + 
                             helper(dp,i+1,j+2,n-1)%mod + 
                             helper(dp,i+2,j+1,n-1)%mod + helper(dp,i+2,j-1,n-1)%mod +
                             helper(dp,i+1,j-2,n-1)%mod + helper(dp,i-1,j-2,n-1)%mod + 
                             helper(dp,i-2,j-1,n-1)%mod + helper(dp,i-2,j+1,n-1)%mod ; 
    }
}
