// problem link : https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int forward = Integer.MIN_VALUE;
        int backward = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0 ; i < n ; i++){
            prod = prod * nums[i];
            forward = Math.max(forward,prod);
            if(prod==0) prod =1 ;
        }
        prod = 1;
        for(int i = n-1 ; i>=0 ; i--){
            prod = prod * nums[i];
            backward = Math.max(backward, prod);
            if(prod==0) prod =1;
        }
        return Math.max(forward , backward);
    }
}
