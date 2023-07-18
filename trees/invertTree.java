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
// Problem link : https://leetcode.com/problems/invert-binary-tree/
class Solution {
    private void helper(TreeNode root){
        TreeNode temp= root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        helper(root);       // swap
        invertTree(root.left);          // do swap for left subtree
        invertTree(root.right);         // similarly for right subtree
        return root;
    }
}
