// problem link : https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ;i < nums.length - 2; i++){
            List<Integer> li = new ArrayList<>();
            int start = i+1 ;
            int end = nums.length -1;
            if(i>0 && i<nums.length && nums[i-1]==nums[i]) continue;
            while(start<end){
                
                if(nums[start]+ nums[end] + nums[i]==0){
                    li.add(nums[start]);
                    li.add(nums[end]);
                    li.add(nums[i]);
                    start++;
                    end--;
                    while(start > 0 && start < nums.length && nums[start-1] == nums[start]) start++;  // to avoid duplicates answer
                    ans.add(new ArrayList<>(li));
                    li.clear();
                }
                else if(nums[start]+ nums[end] + nums[i] > 0){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return ans;
    }
}
