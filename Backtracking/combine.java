// problem link : https://leetcode.com/problems/combinations/
class Solution {
    public void helper(List<List<Integer>> ans , List<Integer> li , int n , int k , int start,int count ){
        if(count==k){
            ans.add(new ArrayList<>(li));
        } 
        for(int i = start ; i<=n ; i++){
            
            li.add(i);
            count++;
            helper(ans,li,n,k,i+1,count);
            count--;
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),n,k,1,0);
        return ans;
    }
}
