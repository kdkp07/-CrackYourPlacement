// Problem link : https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n+1][m+1];
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1; j< dp[0].length ;j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
