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
Problem link : https://leetcode.com/problems/binary-tree-paths/
class Solution {
    private void helper(TreeNode root, List<String> path,StringBuilder sb){
        if(root==null){
            return;
        }
        int l = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right == null){
            path.add(sb.toString());
        }
        else{
            sb.append("->");
            helper(root.left,path,sb);
            helper(root.right,path,sb);
        }
        sb.setLength(l);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        helper(root,path,new StringBuilder());
        return path;
    }
}
