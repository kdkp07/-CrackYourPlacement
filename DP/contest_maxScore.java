// Problem link: https://leetcode.com/problems/visit-array-positions-to-maximize-score/
// This problem is from Leetcode Biweekly contest 109
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long odd = nums[0];
        long even = nums[0];
        if(nums[0]%2==0){
            odd -= x;
        }
        else{
            even -=x;
        }
        for(int i = 1 ; i < n;i++){
            if(nums[i]%2==0){       // even number || two choices , if we take from previous odd number then subtract x from odd and if taking from even then taking as it is.
                even = nums[i]+Math.max(even,odd-x);
            }   
            else{
                odd = nums[i] + Math.max(even-x,odd);
            }
        }
        return Math.max(odd,even);
    }
}
