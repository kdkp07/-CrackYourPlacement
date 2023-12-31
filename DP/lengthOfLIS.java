// Problem link : https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0 ; i < dp.length ; i++){
            int max = 0; 
            for(int j = 0 ; j < i ; j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
