/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Problem link : https://leetcode.com/problems/path-sum/
class Solution {
    private boolean flag = false;
    private void helper(TreeNode root , int t,int sum){
        if(root==null)return;
        sum += root.val;
        if(root.left==null && root.right==null){
            // leaf
            if(sum==t){
                flag = true;
                return;
            }
            else{
                sum -= root.val;
                return;
            }
        }
        helper(root.left,t,sum);
        helper(root.right, t, sum);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,0);
        return flag;
    }
}
