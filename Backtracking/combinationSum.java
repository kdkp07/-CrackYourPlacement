// problem link : https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,ans,new ArrayList<>(),nums,target);
        return ans;
    }
    
    public void helper(int idx,List<List<Integer>> ans , List<Integer> li, int[] nums,int target){
        if(0==target){
            ans.add(new ArrayList<>(li));
            return;
        }
        if(0>target){
            return;
        }
         
        for(int i = idx ; i < nums.length ; i++){
            li.add(nums[i]);
            helper(i,ans,li,nums,target-nums[i]);
            li.remove(li.size()-1);
        }
    }
   
}
