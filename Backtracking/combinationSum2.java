// problem link : https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public void helper(int idx,List<List<Integer>> ans , List<Integer> li, int[] nums,int target){
        if(0==target){
            ans.add(new ArrayList<>(li));
            return;
        }
        if(0>target){
            return;
        }
         
        for(int i = idx ; i < nums.length ; i++){
            if (i > idx && nums[i] == nums[i-1]) continue;
            li.add(nums[i]);
            helper(i+1,ans,li,nums,target-nums[i]);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,ans,new ArrayList<>(),nums,target);
        return ans;
    }
}


// 1 2 5
