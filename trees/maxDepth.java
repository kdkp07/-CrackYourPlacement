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
// Problem link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
class Solution {
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        return 1 + Math.max(lh,rh);
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return helper(root);
    }
}
