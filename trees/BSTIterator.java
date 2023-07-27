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
// problem link : https://leetcode.com/problems/binary-search-tree-iterator/
class BSTIterator {
    private List<Integer> li = new ArrayList<>();
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        li.add(root.val);
        helper(root.right);
    }
    public BSTIterator(TreeNode root) {
        helper(root);
        
    }
    
    public int next() {
        int val = li.get(0);
        li.remove(0);
        return val;
    }
    
    public boolean hasNext() {
        if(li.size()!=0) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
