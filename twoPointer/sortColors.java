// problem link : 
class Solution {
    public void sortColors(int[] nums) {
        int ones = 0, twos = 0 , zeros = 0;
        for(int i : nums){
            if(i==0) zeros++;
            else if(i==1) ones++;
            else twos++;
        }
        int idx = 0;
        int n = nums.length;
        while(n>0){
            n--;
            if(zeros>0){
                nums[idx++] =0;
                zeros--;
            }
            else if(ones>0){
                nums[idx++] = 1;
                ones--;
            }
            else if(twos>0){
                nums[idx++] =2;
                twos--;
            }
        }
    }
}
