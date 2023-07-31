// problem link : https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums,new ArrayList<>(),ans,0);
        return ans;
    }
    public void helper(int[] nums , List<Integer> li , List<List<Integer>> ans,int idx){
        ans.add(new ArrayList<>(li));
        for(int i = idx ; i <nums.length ;i++){
            if(i>idx && nums[i]==nums[i-1] ) continue;
            li.add(nums[i]);
            helper(nums,li,ans,i+1);
            li.remove(li.size()-1);
        }
    }
}

