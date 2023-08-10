// Problem link:https://leetcode.com/problems/permutations-ii/
class Solution {
    public void helper(List<List<Integer>> ans , List<Integer> li , int[] nums,boolean[] vis){
        if(li.size() == nums.length){
            ans.add(new ArrayList<>(li));
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(vis[i]==true || i>0 && nums[i-1]==nums[i] && vis[i-1]!=true) continue;
            vis[i] = true;
            li.add(nums[i]);
            helper(ans,li,nums,vis);
            vis[i] = false;
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans,new ArrayList<>(),nums,new boolean[nums.length+1]);
        return ans;
    }
}
