// problem link : https://leetcode.com/problems/frog-jump/
class Solution {
    public boolean canCross(int[] nums) {
        int n = nums.length;
        if(nums[1]!=1) return false;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            hm.put(nums[i],i);
        }
        int[][] dp  = new int[2001][2001];
        dp[0][0] =1 ;
        for(int i = 0 ; i < n ; i++){
            for(int lastJump = 0 ; lastJump<=n;lastJump++){
                if(dp[i][lastJump]==1){
                    if(hm.containsKey(lastJump+nums[i])){
                        dp[hm.get(lastJump+nums[i])][lastJump] = 1;
                    }
                    if(hm.containsKey(lastJump+1+nums[i])){
                        dp[hm.get(lastJump+1+nums[i])][lastJump+1] = 1;
                    }
                    if(hm.containsKey(lastJump-1 +nums[i])){
                        dp[hm.get(nums[i]+lastJump-1)][lastJump-1] = 1;
                    }
                    
                }
            }
        }
        for(int i = 0 ; i <=n ;i++){
            if(dp[n-1][i]==1){
                return true;
            }
        }
        return false;
    }
}
