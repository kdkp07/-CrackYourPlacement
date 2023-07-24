// Problem link : https://leetcode.com/problems/delete-and-earn/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[10001];
        for(int i =0; i <nums.length;i++){
            sums[nums[i]] += nums[i];
        }
        int pick = sums[0];
        int notpick = 0;
        for(int i = 1 ; i < sums.length;i++){
            int p = sums[i] + notpick;
            int np = Math.max(pick,notpick);
            
            pick = p;
            notpick = np;
        }
        return Math.max(pick,notpick);
    }
}
