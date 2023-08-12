// problem link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// the Priority Queue solution is  availabe in submissions.
class Solution {
    public boolean helper(int[][] mat,int mid,int k,int n){
        int count = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0 ; j < n ;j++){
                if(mat[i][j]<=mid){
                    count++;
                }
            }
        }
        if(count<k) return false;
        return true;
    }
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n-1][n-1];
        while(low<=high){
            int mid = low + (high-low)/2; 
            boolean tmp = helper(mat,mid,k,n);
            // let mid be the answer and count all the elements less than or equal to mid 
            if(tmp){
                high  = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
