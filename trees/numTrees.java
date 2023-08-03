// PROBLEM LINK : https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    public int helper(int n){
        // catalan number
        int[] dp = new int[n+1];
        dp[0] = 1 ; dp[1] =1 ;
        for(int i = 2; i <=n;i++){          // placing every number as root
            dp[i] = 0;          // FOR EVERY NUMBER WE CALCULATE ITS CATALAN NUMBER
            for(int j = 0 ; j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
        // FOR N = 3:  AND ROOT = 2 : C0*C2 + C1*C1 + C2*C0
        // FOR N = 4 ; AND ROOT = 2 : C0*C3 + C1*C2 + C2*C1 + C3*C0
    }
    public int numTrees(int n) {

        return helper(n);
    }
}
