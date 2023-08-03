// problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val) || root==p || root==q){
            return root;
        }
        TreeNode left = null , right = null;
        if(root.val > p.val && root.val > q.val){
            left = lowestCommonAncestor(root.left, p,q);
        }
        if(root.val < p.val && root.val < q.val){
            right = lowestCommonAncestor(root.right,p,q);
        }
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
