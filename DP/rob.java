// Problem link : https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int pick = nums[0];
        int notpick = 0;
        for(int i = 1 ;i < n ; i++){
            int p = nums[i] + notpick;
            int np = Math.max(pick,notpick);
            
            pick = p;
            notpick = np;
        }
        return Math.max(pick,notpick);
    }
}
