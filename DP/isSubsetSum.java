// problem link ; https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int target){
        // code here
        
        boolean[][] dp = new boolean[arr.length][target+1];
        for(int i = 0 ; i < N ; i++){
            dp[i][0]  = true;      // target 0 as 1 
        }
        if(target>=arr[0]){
            dp[0][arr[0]] = true;   // if index is 0 and we got the target then marking it as 1
        }
           
        for(int i = 1; i <N ; i++){
            for(int j = 1 ; j<=target ; j++){
                boolean nottake = dp[i-1][j];
                boolean take = false;
                if(j>=arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || nottake;
            }
        }
        return dp[N-1][target];
    }
}
