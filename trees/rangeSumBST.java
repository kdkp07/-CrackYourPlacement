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

// Problem link : https://leetcode.com/problems/range-sum-of-bst/
class Solution {
    private int ans = 0;
    private void helper(TreeNode root , int low , int high){
        if(root!=null){
            if(root.val >= low && root.val <= high){
                ans += root.val;
            }
            if(root.val > low){
                helper(root.left, low, high);
            }
            if(root.val < high){
                helper(root.right, low,high);
            }
        }
        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        helper(root,low,high);
        return ans;
    }
}
