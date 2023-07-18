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

// problem link : https://leetcode.com/problems/diameter-of-binary-tree/
class Solution {
    private int max = 0;
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
        max = Math.max(max,rh+lh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
}
