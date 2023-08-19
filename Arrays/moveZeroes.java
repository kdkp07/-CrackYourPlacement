// problem link : https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int[]arr = new int[nums.length];
        int nonzero = 0;
        int zero = nums.length-1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                arr[zero] = 0;
                zero--;
            }
            else{
                arr[nonzero] = nums[i];
                nonzero++;
            }
        }
        for(int i  = 0;i<nums.length;i++){
            nums[i] = arr[i];
        }
    }
}
