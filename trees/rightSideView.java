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
// problem link : https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int firstNode = 1 ;
            for(int i = 0; i < size ; i++){
                TreeNode node = q.poll();
                if(firstNode==1 && node!=null){
                    rightView.add(node.val);
                }
                firstNode = 0 ;
                if(node!=null && node.right!=null) q.add(node.right);
                if(node !=null && node.left!=null) q.add(node.left);
                
            }
        }
        return rightView;
    }
}
