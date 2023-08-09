// problem link : https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dpMax = new int[n][n];
        for(int g = 0; g < n ; g++){
            for(int i = 0, j = g ; j < n ;i++,j++){
                if(g==0){
                    dpMax[i][j] = arr[i];
                }
                else if(g==1){
                    dpMax[i][j] = Math.max(arr[i],arr[j]);
                }
                else{
                    dpMax[i][j] = Math.max(dpMax[i+1][j],arr[i]);
                }
            }
        }
        int[][] dp = new int[n][n];
        for(int g = 0 ; g  < n ; g++){
            for(int i = 0, j = g ; j < n ;i++,j++){
                if(g==0){
                    dp[i][j] = 0;
                }
                else if (g==1){
                    dp[i][j] = arr[i] * arr[j];
                }
                else{
                    // g>1
                    int min = Integer.MAX_VALUE;
                    for(int k = i ; k < j ; k++){
                        int left = dpMax[i][k];
                        int right =dpMax[k+1][j];
                        for(int l = k+1 ; l<=j;l++){
                            right = Math.max(right,arr[l]);
                        }
                        min = Math.min(min,left*right+dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }
}
