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
// Problem link : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
class Solution {
    private void inorder(TreeNode root, List<Integer> li){
        if(root==null) return;
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right,li);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inorder(root,li);
        int mini = Integer.MAX_VALUE;
        int n = li.size();
        for(int i = 0 ; i< n-1;i++){
            int diff = Math.abs(li.get(i) - li.get(i+1) );
            mini = Math.min(mini,diff);
        }
        return mini;
    }
}
