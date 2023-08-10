// problem link : https://leetcode.com/problems/beautiful-arrangement/
class Solution {
    private int count =0;
    public void helper(int n ,int idx,int[] vis){
        if(idx>n){
            count++;
            return;
        }
            for(int i = 1 ;i<=n;i++){
                if(vis[i]== 0 && (i%idx==0 || idx%i==0)){
                    vis[i] = 1;
                    helper(n,idx+1,vis);
                    vis[i] = 0;
                } 
            }
    }
    public int countArrangement(int n) {
        helper(n,1,new int[n+1]);
      
        return count;
    }
}
