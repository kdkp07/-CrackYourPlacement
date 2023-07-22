// Problem link : https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans = 0;
        int[][] dp = new int[n1+1][n2+1];
        // same as longest common substring
        // the dp[i][j] will store the length longest common suffix in both arrays till length i and j
        for(int i = 1 ; i < dp.length ; i++){
            for(int j =  1; j < dp[0].length;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
