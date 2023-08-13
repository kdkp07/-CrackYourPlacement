//problem link : https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);    // SUM = 0 HAS FREQ 1
        int ans = 0;
        int sum = 0;
        for(int i = 0 ;i < n ; i++){
            sum += nums[i];
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}
