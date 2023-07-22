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
// Problem link : https://leetcode.com/problems/sum-of-left-leaves/
class Solution {
    private int sum =0;
    private void helper(TreeNode root){
        if(root==null) return;
        if(root.left!=null) {
            if(root.left.left==null && root.left.right==null){
                sum += root.left.val;
            }
            else{
                helper(root.left);
            }
            
        }
        helper(root.right);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;
    }
}
