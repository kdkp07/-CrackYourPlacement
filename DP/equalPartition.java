// problem link : https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i : arr) sum += i;
        if(sum%2!=0) return 0;
        
        int target = sum/2;
        
        boolean[][] dp = new boolean[N][target+1];
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
        return ( dp[N-1][target] == true ) ?1:0;
    }
}
